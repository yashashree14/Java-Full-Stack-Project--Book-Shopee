import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerRegisterservlet")
public class CustomerRegister extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nm=req.getParameter("name");
		String addr=req.getParameter("addr");
		long phn=Long.parseLong(req.getParameter("phn"));
		
			Random rand = new Random();		   
	        int rand_int1 = rand.nextInt(10000000);
	        
		HttpSession session=req.getSession();
		int quantity=(int)session.getAttribute("qty");
		String BKID=(String) session.getAttribute("bkid");
		System.out.println(nm+" "+phn+" "+addr+" "+quantity+" "+BKID);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded in CustomerRegister Page");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_shopee","root","root");
			System.out.println("Connection success in CustomerRegister page");
			
			PreparedStatement pstm=con.prepareStatement("insert into customer_details(Order_Id ,Customer_Name,Phone,Address,Qty,Books_ID,Order_Date) values (?,?,?,?,?,?,CURDATE())");
			
			pstm.setInt(1, rand_int1);
			pstm.setString(2,nm);
			pstm.setLong(3,phn);
			pstm.setString(4,addr);
			pstm.setInt(5,quantity);
			pstm.setString(6,BKID);
			
			int i=pstm.executeUpdate();
			
			if(i!=0)
			{
				System.out.println("Record inserted");
				resp.sendRedirect("ThankuPage.jsp");
			}
			else
			{
				System.out.println("Error");
				resp.sendRedirect("UserDetails.jsp");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
