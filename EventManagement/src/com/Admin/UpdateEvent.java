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
 * Servlet implementation class UpdateEvent
 */
@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {
	String url= "jdbc:sqlserver://localhost:1433;databasename= clg_mgmt;";
	String usrname= "root";
	String pass= "root";
	String sql5= "update event_details set date= ?, venue= ?, fees= ?, About= ? where name= ?;";
	public void updateeve(String ename, String dt, String venue, String fees, String abt)
	{
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql5);
		st.setString(5, ename);
		st.setString(1, dt);
		st.setString(2, venue);
		st.setString(3, fees);
		st.setString(4, abt);
		st.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block

	}
		}
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename= request.getParameter("ename");
		String dt= request.getParameter("dt");
		String venue= request.getParameter("venue");
		String fees= request.getParameter("fees");
		String abt= request.getParameter("abt");
		updateeve(ename, dt, venue, fees, abt);
		response.sendRedirect("AdminOptions.jsp");

	}

}
