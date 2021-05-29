package com.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteRec
 */
@WebServlet("/DeleteRec")
public class DeleteStudent extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306;databasename=mysql_database;";
	String usrname= "root";
	String pass= "root";
	String sql= "delete from studentrecords where username= ?;";
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		String username= request.getParameter("username");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection(url, usrname, pass);
			PreparedStatement st1= con.prepareStatement(sql);
			st1.setString(1, username);
			st1.executeUpdate();
			HttpSession session= request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("AdminOptions.jsp");
		} catch (IOException | ClassNotFoundException | SQLException e) {
		}	
	}

}
