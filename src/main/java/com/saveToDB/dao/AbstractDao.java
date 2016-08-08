package com.saveToDB.dao;

import com.saveToDB.DBConnection.DataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by KIRILL on 13.04.2016.
 */
public class AbstractDao<T> {

    private Connection conn;

    public Connection getConnection() throws SQLException, IOException, PropertyVetoException {
        DataSource connectionPool = DataSource.getInstance();
        return conn = connectionPool.getConnection();
    }


}
