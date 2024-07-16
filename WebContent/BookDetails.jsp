<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<form action="UserServlet" >
 	<center>
		<h1>Shopping Cart for Book Store</h1>
		<h1>Selected Book Details are displayed</h1>
		<br><br>
		
		<%
		try
		{
		ResultSet rs=(ResultSet)session.getAttribute("rs2");
		while(rs.next())
		{
		
		%>
		
		<h3>
			Book Name-----><%=rs.getString("Books_Name")%>
		</h3>
		<br>
		<br>
		<h3>
			Author-----><%=rs.getString("Author") %>
		</h3>
		<br>
		<br>
		<h3>
			Price-----><%=rs.getInt("Price") %>
		</h3>
		<br>
		<br>
		Quantity:<input type="number" name="QTY"><br><br><br>
		<button type="submit">Purchase</button>
		<%
		}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		%>
		
	</center>
 	</form>
 	
 	<form action="Index.jsp">
 	<center><button type="submit">Cancel</button></center>
 	
 	
 	</form>
</body>
</html>