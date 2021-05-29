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

/**
 * Servlet implementation class ChngPass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306;databasename= mysql_database;";
	String usrname= "root";
	String pass= "root";
	String sql= "update adminrecords set pass=? where username=?;";
	public void updaterec(String username, String password)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(2, username);
		st.setString(1, password);
		st.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
	}
		}
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
	String username= request.getParameter("username");
	String password= request.getParameter("password");
	updaterec(username, password);
	response.sendRedirect("AdminOptions.jsp");
	}
	
}
