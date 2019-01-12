package com.dranawhite.common.template;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.file.DranaExcelException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel读取
 *
 * @author liangyuquan
 * @version $Id: ExcelReader.java, v 0.1 2018-12-19 20:37 liangyuquan Exp $$
 */
public final class ExcelReader {

    /**
     * 读取Excel数据
     *
     * @param ins         文件流
     * @param tplTitleArr 模板标题
     * @return DataSet
     */
    public static DataSet<Object> readExcel(InputStream ins, String[] tplTitleArr) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(ins);
            Sheet sheet = workbook.getSheetAt(0);
            validateExcelTpl(sheet, tplTitleArr);

            DataSet<Object> resultSet = new DataSet();
            Row header = sheet.getRow(sheet.getFirstRowNum());
            FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(workbook);
            List<String> columnNameList = new ArrayList<>(tplTitleArr.length);
            // 组装Sheet标题栏
            int expectColNum = tplTitleArr.length;
            for (int cellNum = header.getFirstCellNum(); cellNum < expectColNum; cellNum++) {
                Cell titleCell = header.getCell(cellNum);
                columnNameList.add(titleCell == null ? "" : titleCell.getStringCellValue());
                resultSet.setTitleList(columnNameList);
            }
            // 组装Sheet数据栏
            for (int dataNum = sheet.getFirstRowNum() + 1, dataMaxNum = sheet.getLastRowNum() + 1; dataNum < dataMaxNum;
                 dataNum++) {
                Row row = sheet.getRow(dataNum);
                DataRow<Object> dataRow = new DataRow();
                // 空单元格计数
                int blankCellNum = 0;
                for (int cellNum = header.getFirstCellNum(); cellNum < expectColNum; cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                        dataRow.addField("");
                        if (++blankCellNum == expectColNum) {
                            // 如果每个Cell都是空的，则认为已经读取到文件末尾
                            return resultSet;
                        }
                        continue;
                    }
                    dataRow.addField(transferCellType(cell, formulaEvaluator));
                }
                resultSet.addRow(dataRow);
            }
            return resultSet;
        } catch (IOException ex) {
            throw new DranaExcelException("读取Excel模板错误", ResultCodeEnum.TEMPLATE_ERR, ex);
        }
    }

    private static void validateExcelTpl(Sheet sheet, String[] tplTitleArr) {
        if (sheet == null) {
            throw new DranaExcelException("Excel模板错误, 找不到Sheet页", ResultCodeEnum.TEMPLATE_EXCEL_SHEET_LACK);
        }

        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        if (lastRowNum < 1) {
            throw new DranaExcelException("Excel模板错误, 数据为空", ResultCodeEnum.TEMPLATE_DATA_LACK);
        }

        Row row = sheet.getRow(firstRowNum);
        int expectColNum = tplTitleArr.length;
        int actualColNum = row.getLastCellNum();
        if (actualColNum != expectColNum) {
            throw new DranaExcelException("Excel模板错误, 数据列数不对应", ResultCodeEnum.TEMPLATE_ILLEGAL_FORMAT);
        }

        for (int colNum = 0; colNum < expectColNum; colNum++) {
            Object title = row.getCell(colNum);
            String titleText = title == null ? "" : title.toString();
            for (int index = 0; index < expectColNum; index++) {
                if (titleText.equals(tplTitleArr[index])) {
                    break;
                } else if (index == expectColNum - 1) {
                    throw new DranaExcelException("Excel模板错误, 标题不对应", ResultCodeEnum.TEMPLATE_ILLEGAL_TITLE);
                }
            }
        }
    }

    /**
     * 转换单元格数值格式
     *
     * @param cell             单元格
     * @param formulaEvaluator 表达式计算器
     * @return obj
     */
    private static Object transferCellType(Cell cell, FormulaEvaluator formulaEvaluator) {
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_FORMULA: {
                return formulaEvaluator.evaluate(cell).getNumberValue();
            }
            case XSSFCell.CELL_TYPE_NUMERIC: {
                return cell.getNumericCellValue();
            }
            case XSSFCell.CELL_TYPE_BOOLEAN: {
                return cell.getBooleanCellValue();
            }
            default: {
                return cell.getStringCellValue();
            }
        }
    }
}
