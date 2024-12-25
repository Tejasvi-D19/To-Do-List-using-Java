package com.userIno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String userEmail = req.getParameter("username");
		String upassword = req.getParameter("password");
		String pass = null;
		ResultSet rs ;
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userData", "root", "Teja@2004");
			PreparedStatement ps = con.prepareStatement("SELECT email FROM users WHERE email = ? and password = ?");
			
			ps.setString(1, userEmail);
			ps.setString(2, upassword);
			rs = ps.executeQuery();
			if(rs.next()) 
			{
				res.sendRedirect("first.html");
			}
			else 
			{
				res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid email or password. Please try again.');");
                out.println("window.location.href = 'login.jsp';"); // Redirect to login page
                out.println("</script>");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
