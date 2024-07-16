import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/BookServlet")
public class BookDetails extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession s1=req.getSession();
		String BookID=(String)s1.getAttribute("bkid");
		System.out.println("Book ID in book servlet="+BookID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopee", "root", "root");
			System.out.println("Connection success");
			
			PreparedStatement pstm=con.prepareStatement("select * from books where Books_ID=?");
			pstm.setString(1, BookID);
			
			ResultSet rs=pstm.executeQuery();
			
			s1.setAttribute("rs2", rs);
			//s1.setAttribute("UserBookId", bId);
			resp.sendRedirect("BookDetails.jsp");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
