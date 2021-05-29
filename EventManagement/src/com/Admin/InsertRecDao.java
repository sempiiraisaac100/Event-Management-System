/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author o876
 */
public class InsertRecDao {
    
    public int insertrec(InsertRecBean insertRecBean) throws ClassNotFoundException {
            String INSERT_STUDENT_SQL = "INSERT INTO login" +
            "  (username, password) VALUES " +
            " (?, md5(?));";
            
            int result = 0;
        

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, insertRecBean.getUsername());
            preparedStatement.setString(2, insertRecBean.getPassword());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}
