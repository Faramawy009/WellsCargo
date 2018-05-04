package controller;

import model.User;
import model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User loggedIn = UserDB.getUser(userName);
		if(loggedIn != null) { //User name already exists.
			request.setAttribute("loginerror", "Username already exists, please pick a different one!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		UserDB.addUser(userName,password);
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("loginerror", "New User "+userName+" Was Successfully Created.");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}


