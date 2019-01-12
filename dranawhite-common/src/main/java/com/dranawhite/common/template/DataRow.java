package com.dranawhite.common.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * 记录行
 *
 * @author dranawhite
 * @version $Id: DataRow.java, v 0.1 2018-09-13 9:48 dranawhite Exp $$
 */
public class DataRow<T> implements Iterable<T>, RandomAccess, Serializable {

    private static final long serialVersionUID = 8814397727270915604L;

    private List<T> list;

    public DataRow() {
        list = new ArrayList<>();
    }

    public void addField(T field) {
        list.add(field);
    }

    public T getField(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
