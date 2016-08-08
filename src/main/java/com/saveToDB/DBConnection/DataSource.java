package com.saveToDB.DBConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by KIRILL on 09.04.2016.
 *
 * c3po poolconnection to Db
 */

public class DataSource {

    private static DataSource datasource;
    private ComboPooledDataSource cpds;

    private static final String url = ResourceBundle.getBundle("resources").getString("dbUrl");
    private static final String user = ResourceBundle.getBundle("resources").getString("dbUser");
    private static final String password = ResourceBundle.getBundle("resources").getString("dbPass");
    private static final String driver = ResourceBundle.getBundle("resources").getString("dbDriver");

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass(driver); //loads the jdbc driver
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(password);

        // the settings below are optional -- c3p0 can work with defaults
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);

    }

    public static synchronized DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
