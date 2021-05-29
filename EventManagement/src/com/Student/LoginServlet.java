/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Student;

/**
 *
 * @author o876
 */
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import net.javaguides.login.bean.LoginBean;
//import net.javaguides.login.database.LoginDao;

/**
 *
 */

@WebServlet("/StudentLogin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    @Override
    public void init() {
        loginDao = new LoginDao();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session= request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("StudentOptions.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("StudentLogin.jsp");
            }
        } catch (ClassNotFoundException e) { }        
    }
}
