package com.dranawhite.common.template;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.date.DateUtil;
import com.dranawhite.common.exception.DranaFileException;
import com.dranawhite.common.exception.GenericResultCode;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Excel工具类
 *
 * @author dranawhite
 * @version $Id: ExcelGenerator.java, v 0.1 2018-09-21 20:39 dranawhite Exp $$
 */
public final class ExcelGenerator {

    private static final String EXCEL_DOWN_LOAD_DIR = "/data/download/excel";

    private static final String EXCEL_SUFFIX = ".xlsx";

    /**
     * double类型最大能表示的整数(16位)
     */
    private static final Long EXCEL_MAX_LONG = 999999999999999L;

    /**
     * 生成Excel文件
     *
     * @param titleList 列名
     * @param resultSet 数据集
     * @param fileName  文件名
     * @return Path
     */
    public static String generateExcel(List<String> titleList, DataSet<Object> resultSet, String fileName) {
        List<DataRow<Object>> rowList = resultSet.getValueList();
        if (CollectionUtils.isEmpty(titleList)) {
            throw new DranaFileException("Excel表头不能为空!", GenericResultCode.SYSTEM_ERROR);
        }

        // 创建文件目录
        StringBuilder dirSb = new StringBuilder();
        dirSb.append(EXCEL_DOWN_LOAD_DIR).append(File.separator)
                .append(DateUtil.format(new Date(), DateUtil.DateFormat.SERIAL_DAY));
        createDirectoryIfNotExists(dirSb.toString());
        StringBuilder pathSb = new StringBuilder(dirSb);
        pathSb.append(File.separator).append(fileName).append(Separator.StringSeparator.UNDER_LINE)
                .append(DateUtil.formatSerialSecond(new Date())).append(EXCEL_SUFFIX);

        // 生成表头
        SXSSFWorkbook workbook = null;
        try {
            workbook = new SXSSFWorkbook(1000);
            Sheet sheet = workbook.createSheet();
            generateExcelHeader(sheet, titleList);
            generateExcelData(sheet, rowList);
            saveExcel(workbook, pathSb.toString());
        } catch (Exception ex) {
            throw new DranaFileException("生成Excel文件失败!", GenericResultCode.SYSTEM_ERROR, ex);
        } finally {
            if (workbook != null) {
                workbook.dispose();
            }
        }
        return pathSb.toString();
    }

    /**
     * 创建文件目录
     *
     * @param dir 目录
     */
    private static void createDirectoryIfNotExists(String dir) {
        File workDirectory = new File(dir);
        if (workDirectory.exists()) {
            return;
        }
        if (!workDirectory.mkdirs()) {
            throw new DranaFileException("创建目录失败!", GenericResultCode.SYSTEM_ERROR);
        }
        workDirectory.setWritable(true, false);
        workDirectory.setExecutable(true, false);
    }

    /**
     * 创建文件
     *
     * @param fileName 文件名
     */
    private static void saveExcel(Workbook workbook, String fileName) {
        try (FileOutputStream outs = new FileOutputStream(fileName)) {
            workbook.write(outs);
        } catch (IOException ex) {
            throw new DranaFileException("创建Excel失败, PATH = [{}]", GenericResultCode.SYSTEM_ERROR, fileName);
        }
    }


    /**
     * 产生表头
     *
     * @param sheet     Sheet页
     * @param titleList 列名
     */
    private static void generateExcelHeader(Sheet sheet, List<String> titleList) {
        Row rowHeader = sheet.createRow(0);
        // 字体:微软雅黑, 12; 背景色:灰色,铺满单元格;
        int headerCellNum = 0;
        for (String columnName : titleList) {
            Cell cell = rowHeader.createCell(headerCellNum++);
            cell.setCellValue(columnName.trim());
        }
    }

    /**
     * 生成表格数据
     *
     * @param sheet   Sheet页
     * @param rowList 行数据
     */
    private static void generateExcelData(Sheet sheet, List<DataRow<Object>> rowList) {
        if (CollectionUtils.isEmpty(rowList)) {
            return;
        }

        int rowNum = 1;
        for (DataRow<Object> dataRow : rowList) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object value : dataRow) {
                Cell cell = row.createCell(colNum++);
                if (value == null) {
                    cell.setCellValue("");
                } else if (value instanceof Date) {
                    cell.setCellValue((Date) value);
                } else if (value instanceof Integer || value instanceof Double) {
                    cell.setCellValue(Double.valueOf(value.toString()));
                } else if (value instanceof Long && (Long) value <= EXCEL_MAX_LONG) {
                    cell.setCellValue(Double.valueOf(value.toString()));
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        }
    }
}
