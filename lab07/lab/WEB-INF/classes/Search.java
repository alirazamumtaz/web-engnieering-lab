import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Search extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String login_id = request.getParameter("login_id");
		String login_password = request.getParameter("login_password");
		PrintWriter out = response.getWriter();
		// out.println(" <html><head><title> Login Lab Task </titke> </head><body>");
		out.println("<html>");
		out.println("<head><title>Login Screen</title></head>");
		out.println("<body bgcolor=\"#ffffff\"><h1Welcome></h1> ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Lab07","root","ali@pucit");
			Statement stmt = conn.createStatement();
			ResultSet login_info =  stmt.executeQuery("SELECT * FROM login_info WHERE login_id='" + login_id +"' ");
			if(login_info.next()){
				if(login_password.equals (login_info.getString("login_password").strip())){
					out.println("<h1> Success </h1>");
				}
				else {
					out.println("<h1> User Name or Password is wrong </h1>");
				}
				
			}
			else {
				out.println("<h1>No Record Found</h1>");
			}
			out.println("</body></html>");
			stmt.close();
			conn.close();
		} catch ( Exception e ){
			System.out.println(e);
		}
		
	} 
}