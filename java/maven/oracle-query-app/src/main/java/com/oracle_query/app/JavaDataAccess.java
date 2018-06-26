package com.oracle_query.app;


import java.sql.*;

public class JavaDataAccess {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        String tnsnamesora = "/Users/01014477/git/byam/hello-world/java/maven/oracle-query-app/tnsnames.ora";

//        System.setProperty("oracle.net.tns_admin", tnsnamesora);

        // Oracle JDBC Driverのロード
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Oracle8iに接続
        Connection conn = DriverManager.getConnection(
//                "jdbc:oracle:thin:@172.17.14.208:15030/svc_jlncbi",
                "jdbc:oracle:thin:@tns_euc_jlncbi",
                "XXXX",
                "XXXX");


        // ステートメントを作成
        Statement stmt = conn.createStatement();

        // 問合せの実行
        ResultSet rset = stmt.executeQuery("SELECT TO_CHAR (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') date_now FROM DUAL");

        // 問合せ結果の表示
        while ( rset.next() ) {
            // 列番号による指定
            System.out.println("date_now: " + rset.getString(1));
        }

        // 結果セットをクローズ
        rset.close();

        // ステートメントをクローズ
        stmt.close();

        // 接続をクローズ
        conn.close();
    }
}
