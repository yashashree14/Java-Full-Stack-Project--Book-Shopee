<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<form action="./BookServlet" >
	<center>
		<h1>Shopping Cart for Book Store</h1>
		<h1>Welcome Page</h1>
	
	<table border="2" cellspacing="5" cellpadding="5">
		<tr>
			<th>Book Name</td>
			<th>Author</td>
			<th>Price</td>
		</tr>
		
		<%
		try{
			ResultSet rs=(ResultSet)session.getAttribute("rs1");
			//System.out.println("data in welcomepage.jsp");
			while(rs.next())
			{
				System.out.println();	
		%>
			<tr>
			<td><a href="Book.jsp?BKID=<%= rs.getString("Books_ID")%>"><%=rs.getString("Books_Name") %></a></td>
			<td><%= rs.getString("Author") %></td>
			<td><%= rs.getInt("Price") %></td>
			
			</tr>
		<%
			}
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		%>
			
	
	</table>
	</center>
	</form>
</body>
</html>