package com.learninghibernate.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) {


        String jdbcUrl = "jdbc:mysql://localhost:3306/NameOftheDatabase?useSSL=false&serverTimezone=UTC";
        String user = "DatabaseUserId";
        String password = "DatabaseUserPassword";

        try {
            System.out.println("Connecting to database " +jdbcUrl);
            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,password);

            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
