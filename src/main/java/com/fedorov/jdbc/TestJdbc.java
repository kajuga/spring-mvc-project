package com.fedorov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/hb_student_tracker";
    static final String USER = "kajuga";
    static final String PASS = "sashok";

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
}