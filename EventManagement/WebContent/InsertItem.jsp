<%-- 
    Document   : InsertItem
    Created on : Nov 24, 2020, 10:52:44 AM
    Author     : o876
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//http 1.1
response.setHeader("Pragma", "no-cache");//http 1.0
response.setHeader("Expires", "0");//proxies
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Main.jsp");
	}
%>
<h1>Insert New Item</h1><br>
<img src= "abes.jpg"></img><br>
<h5>* fields are mandatory</h5>
        <form action= "InsertItem" method= "post" onsubmit= "return validaton()">
Item name* <input type= "text" name= "ename" required><br><br>
Lost or Found Date* <input type= "text" name="date" required><br><br>
Location* <input type= "text" name= "location" required><br><br>
Contact*<input type= "text" name= "contact" required><br><br>
About Item Specifications*(not more than 50 characters) <input type= "text" name= "about" required><br><br>
<input type= "submit" value= "Insert item"><br><br>
</form>
<form action= "Logout" method= "post">
<input type= "submit" value= "Logout">
</form>
    </body>
</html>
