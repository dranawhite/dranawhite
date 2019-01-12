package com.dranawhite.common.template;

import org.junit.Test;

/**
 *
 * @author dranawhite
 * @version $Id: DataSetTest.java, v 0.1 2019-01-12 15:49 dranawhite Exp $$
 */
public class DataSetTest {

    @Test
    public void testEnlarge() {
        DataSet<Integer> dataSet = new DataSet<>();
        for (int i = 0; i < 105; i++) {
            dataSet.addRow();
            dataSet.addField(i);
        }
        System.out.println(dataSet.size());
    }
}
