package com.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEvent
 */
@WebServlet("/InsertEvent")
public class InsertEvent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {                
        response.getWriter().append("Served at: ").append(request.getContextPath());        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/InsertEvent.jsp");
        dispatcher.forward(request, response);    
    }
	String url= "jdbc:mysql://localhost:3306;databasename=mysql_database;";
	String username= "root";
	String password= "root";
	String sql= "insert into eventdetails values (?, ?, ?, ?, ?);";
	public void insertevent(String eventname, String date, String venue, String fees, String about){	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection= DriverManager.getConnection(url, username, password);
		PreparedStatement st= connection.prepareStatement(sql);
		st.setString(1, eventname);
		st.setString(2, date);
		st.setString(3, venue);
		st.setString(4, fees);
		st.setString(5, about);
		st.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) { }                  
			}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
		String eventname= request.getParameter("eventname");
		String date= request.getParameter("date");
		String venue= request.getParameter("venue");
		String fees= request.getParameter("fees");
		String about= request.getParameter("about");
		insertevent(eventname, date, venue, fees, about);
		response.sendRedirect("AdminOptions.jsp");

	}

}
