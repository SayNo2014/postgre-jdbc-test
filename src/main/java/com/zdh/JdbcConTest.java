package com.zdh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConTest {
    public static void main(String[] args) {
        System.out.print(" this is a test ");
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url = "jdbc:postgresql://localhost:5432/testdb?currentSchema=demo";
            Connection con = DriverManager.getConnection(url, "postgres", "admin");
            Statement st = con.createStatement();
            String sql = "select * from table_name";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ee) {
            System.out.print(ee.getMessage());
            ee.printStackTrace();
        }
    }
}