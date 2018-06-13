package com.oracle_query.app;

import java.sql.*;
import java.util.TimeZone;

public class JdbcOracle {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String oracleUrl = "jdbc:oracle:thin:@(DESCRIPTION=(ENABLE=BROKEN)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=172.17.14.211)(PORT=15030))(LOAD_BALANCE=OFF)(FAILOVER=ON))(CONNECT_DATA=(SERVICE_NAME=svc_jlncbi)(SERVER=DEDICATED)))";

    public static void main(String[] args) throws SQLException {

        // Set timezone
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");
        TimeZone.setDefault(timeZone);

        try{
            // Returns the Class object associated with the class
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException exception) {
            System.out.println("Oracle Driver Class Not found Exception: " + exception.toString());
        }

        // Set connection timeout. Make sure you set this correctly as per your need
        DriverManager.setLoginTimeout(5);
        System.out.println("Oracle JDBC Driver Successfully Registered! Let's make connection now");

        try {
            // Attempts to establish a connection
            // here DB name: localhost, sid: crunchify
//            connection = DriverManager.getConnection("jdbc:oracle:thin:@172.17.14.211:15030/svc_jlncbi", "exeuc088", "Pi2hCygb");
            connection = DriverManager.getConnection(oracleUrl, "exeuc088", "Pi2hCygb");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        // Creates a Statement object for sending SQL statements to the database
        statement = connection.createStatement();

        // Executes the given SQL statement, which returns a single ResultSet object
        resultSet = statement.executeQuery("SELECT a.rsv_no, a.yad_no FROM euc_mp.j_rsv a WHERE a.rsv_time >= SYSDATE - 60/86400 ORDER BY 2 DESC");

        if (resultSet.next()) {
            System.out.println("[rsv_no]:" + resultSet.getString(1) +
                    " [yad_no]:" + resultSet.getString(2));
        } else {
            throw new SQLException("Can NOT retrieve Employee details from table 'euc_mp.j_rsv'");
        }

        System.out.println("Oracle JDBC connect and query test completed.");
    }
}
