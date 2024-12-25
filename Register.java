package com.userIno;



import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Register extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String userName = req.getParameter("name");
		String email = req.getParameter("email");
		String upassword = req.getParameter("password");
		
		String pass = null;
		ResultSet rs1;
		int rs ;
		
			
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userData", "root", "Teja@2004");
			PreparedStatement ps1 = con.prepareStatement("SELECT email FROM users WHERE email = ?");
			ps1.setString(1, email);
			rs1 = ps1.executeQuery();
			if(rs1.next()) 
			{
				res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User already exist please login.');");
                out.println("window.location.href = 'login.jsp';"); 
                out.println("</script>");
			}
			else 
			{
				PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUE (?, ?, ?)");
				ps.setString(1, userName);
				ps.setString(2, email);
				ps.setString(3, upassword);
				rs = ps.executeUpdate();
	
				res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registered pleas login.');");
                out.println("window.location.href = 'login.jsp';"); 
                out.println("</script>");
			}
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}
		
}
