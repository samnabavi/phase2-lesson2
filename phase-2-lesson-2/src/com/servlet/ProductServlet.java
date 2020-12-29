package com.servlet;

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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String userId = request.getParameter("pId");

		String sql = "select * from SESSION2PRODUCTS";

		try {
			Class.forName("org.h2.Driver");

			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", ""); // establish the connection

			PreparedStatement pst = conn.prepareStatement(sql);
			// System.out.println("here");

			ResultSet rs = pst.executeQuery();

			boolean success = false;
			while (rs.next()) {

				String id = rs.getString(1);
				if (userId.equals(id)) {
					String name = rs.getString(2);
					String model = rs.getString(3);
					String color = rs.getString(4);
					String year = rs.getString(5);
					response.getWriter().println("id: " + id);
					response.getWriter().println("</br>");
					response.getWriter().println("name: " + name);
					response.getWriter().println("</br>");
					response.getWriter().println("model: " + model);
					response.getWriter().println("</br>");
					response.getWriter().println("color: " + color);
					response.getWriter().println("</br>");
					response.getWriter().println("year: " + year);
					response.getWriter().println("</br>");

					success = true;

				}
			}
			if (success == false) {
				response.getWriter().println("We don't have this product. Go to main menu to try again.");
			}
			
			response.getWriter().println("</br>" + "<a href='index.html'>Main Menu</a>");

			

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
		}
	}

}
