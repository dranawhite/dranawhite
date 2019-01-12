package com.dranawhite.common.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据集
 *
 * @author dranawhite
 * @version $Id: DataSet.java, v 0.1 2018-09-13 9:46 dranawhite Exp $$
 */
public class DataSet<T> implements Iterable<DataRow<T>>, Serializable {

    private static final long serialVersionUID = -1553052789295637705L;

    private static final int MAX_ARRAY_LEN = 100;

    private int curSize;

    private boolean needEnlarge = true;

    /**
     * 标题
     */
    @Setter
    @Getter
    private List<String> titleList;

    /**
     * 结果耗时
     */
    @Setter
    @Getter
    private long costTime;

    @Getter
    private List<DataRow<T>> valueList;

    private DataRow<T> curRow;

    public DataSet() {
        valueList = new ArrayList<>();
    }

    public DataSet(int size) {
        if (size <= MAX_ARRAY_LEN) {
            valueList = new ArrayList<>();
        } else {
            needEnlarge = false;
            valueList = new LinkedList<>();
        }
    }

    public void addRow(DataRow col) {
        if (needEnlarge) {
            enlarge(++curSize);
        }
        valueList.add(col);
    }

    public void addRow() {
        DataRow<T> row = new DataRow();
        curRow = row;
        if (needEnlarge) {
            enlarge(++curSize);
        }
        valueList.add(row);
    }

    public void addField(T data) {
        curRow.addField(data);
    }

    public int size() {
        return valueList.size();
    }

    private void enlarge(int size) {
        if (size <= MAX_ARRAY_LEN) {
            return;
        }
        needEnlarge = false;
        LinkedList<DataRow<T>> newValueList = new LinkedList<>(valueList);
        valueList = newValueList;
    }

    @Override
    public Iterator<DataRow<T>> iterator() {
        return valueList.iterator();
    }
}
