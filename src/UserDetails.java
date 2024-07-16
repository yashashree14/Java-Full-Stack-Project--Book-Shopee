import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UserServlet")
public class UserDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session=req.getSession();
		String BookID=(String)session.getAttribute("bkid");
		System.out.println("Book id in User Details Servlet"+BookID);
		int quantity=Integer.parseInt(req.getParameter("QTY"));
		System.out.println("Quantity="+quantity);
		session.setAttribute("qty", quantity);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopee", "root", "root");
			System.out.println("Connection Succesfull");
			
			PreparedStatement pstm=con.prepareStatement("select * from books where Books_Id=?");
			pstm.setString(1, BookID);
			
			ResultSet rs=pstm.executeQuery();
			
			resp.sendRedirect("UserDetails.jsp");
			session.setAttribute("rs3", rs);
			 
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();	
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		}
}
