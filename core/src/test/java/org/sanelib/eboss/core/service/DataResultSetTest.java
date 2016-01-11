package org.sanelib.eboss.core.service;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class DataResultSetTest {

    @Test
    public void getColumnKeyTest() throws SQLException {
        Assert.assertEquals("table.column", DataResultSet.getColumnKey("table", "column"));
    }
}