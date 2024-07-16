import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/WelcomeServlet")
public class WelcomePage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopee", "root", "root");
			System.out.println("Connection success");
			
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from books");
			
			HttpSession session=req.getSession();
			session.setAttribute("rs1", rs);
			
			resp.sendRedirect("WelcomePage.jsp");
			
			//con.close(); rs connected with database for fetching the object
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
