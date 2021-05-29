package com.events;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Showall
 */
@WebServlet("/Showallitems")
public class Showallitems extends HttpServlet {
	String url= "jdbc:mysql://localhost:3306;databasename=mysql_database;";
	String usrname= "root";
	String pass= "root";
	String sql= "select * from eventdetails where date> GETDATE();";
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
	response.setContentType("text/html");
		PrintWriter out= response.getWriter();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql);
		ResultSet rs= st.executeQuery();
		out.print("<html>");
		out.print("<body bgcolor= rgb(160,120,150)>");
		out.print("<center>");
		out.print("<table width=50% border=1>");  
		out.print("<caption><h1>Upcoming Events</h1></caption>");
		ResultSetMetaData col= rs.getMetaData();
		int t= col.getColumnCount();
		out.print("</tr>"); 
		for(int i=1; i<=t; ++i)
		{
			out.println("<th>"+col.getColumnName(i)+"</th>");
		}
		while(rs.next())  
		{  
		out.print("<tr><td>"+rs.getString(1)+"</td><td>"+
                        rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td>"+
                        rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");  
		}
		out.print("</table>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
		} catch (ClassNotFoundException | SQLException e) {
                }	
	
	}

}
