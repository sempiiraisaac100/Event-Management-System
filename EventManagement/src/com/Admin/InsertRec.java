package com.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertRec
 */
@WebServlet("/InsertRec")
public class InsertRec extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InsertRecDao insertRecDao;
    @Override
    public void init() {
        insertRecDao = new InsertRecDao();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        InsertRecBean insertRecBean = new InsertRecBean();
        insertRecBean.setUsername(username);
        insertRecBean.setPassword(password);

        try {
            insertRecDao.insertrec(insertRecBean);             
        } catch (ClassNotFoundException e) {
       }
        response.sendRedirect("AdminOptions.jsp");
    }
}


