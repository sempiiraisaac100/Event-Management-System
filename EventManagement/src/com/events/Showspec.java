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
 * Servlet implementation class Showspec
 */
@WebServlet("/Showspec")
public class Showspec extends HttpServlet {
	String url= "jdbc:sqlserver://localhost:1433;databasename= clg_mgmt;";
	String usrname= "root";
	String pass;
	String sql6= "select * from event_details where About like ? or name like ? or date like ? and date>GETDATE();";

    public Showspec() {
        this.pass = "root";
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ser= request.getParameter("ser");
		PrintWriter out= response.getWriter();
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st= con.prepareStatement(sql6);
		st.setString(1, ser);
		st.setString(2, ser);
		st.setString(3, ser);
		ResultSet rs= st.executeQuery();
		out.print("<html>");
		out.print("<body bgcolor= rgb(160,120,150)>");
		out.print("<center>");
		out.print("<table width=50% border=1>"); 
		out.print("<caption><h1>Your result</h1></caption>");
		ResultSetMetaData col= rs.getMetaData();
		int t= col.getColumnCount();
		out.print("</tr>"); 
		for(int i=1; i<=t; ++i)
		{
			out.println("<th>"+col.getColumnName(i)+"</th>");
		}
		while(rs.next())  
		{  
		out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td></tr>");  
		}
		out.print("</table>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>"); 
		} catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block

	}	
	

	}

}
