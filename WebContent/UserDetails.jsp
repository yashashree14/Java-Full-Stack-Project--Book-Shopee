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
	<center>
		<form action="./CustomerRegisterservlet">
		<h1>Shopping Cart for Book Store</h1>
			<b>Customer Name:</b><input type="text" name="name"><br><br>
			<b>Address      :</b><input type="text" name="addr"><br><br>
			<b>Phone No     :</b><input type="number" name="phn"><br><br>
			
			<h3>Your order Details</h3>
			<table border="2">
				<tr>
				<th>Book Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Price</th>
			</tr>
			
			<%
			try {
			ResultSet rs=(ResultSet)session.getAttribute("rs3");		
			while(rs.next()) {
				int quantity=(int)session.getAttribute("qty");
				int price=rs.getInt("Price");	
			
			%>
			<tr>
				<td><%=rs.getString("Books_Name")%></td>
				<td><%=rs.getString("Author") %></td>
				<td><%=rs.getInt("Price") %></td>
				<td><%=quantity %></td>
				<td><%=quantity*price %></td>
			<%
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			%>
			</tr>
		</table>
		
		<button type="submit">Confirm</button>	
		</form>
		<form action="Index.jsp">
		<button type="submit">Cancel</button>
		</form>
	</center>
</body>
</html>