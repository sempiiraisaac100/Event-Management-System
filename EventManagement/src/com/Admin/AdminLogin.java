package com.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		if(username.equals("Tamale")&&password.equals("Tamale"))
		{
			HttpSession session= request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("AdminOptions.jsp");
		}
		else
		{
			response.sendRedirect("AdminLogin.jsp");
		}
	}

}
