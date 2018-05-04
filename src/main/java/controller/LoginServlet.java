package controller;

import model.Account;
import model.User;
import model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginServlet extends HttpServlet
{

	@Override
	public void init() throws ServletException {
		try {
			UserDB.readDB("Users.db");
		} catch (Exception e) {
		e.printStackTrace();
			System.out.println("Couldn't read Database!\n\n");
		}

	}

	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		List<String> accountTypes = Arrays.asList(Arrays.toString(Account.AccountType.values()).replaceAll("^.|.$", "").split(", "));
		request.getSession().setAttribute("accounttypes", accountTypes);
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			User loggedIn = UserDB.getUser(userName);
			if(loggedIn == null) { //User name does not exist.
				request.setAttribute("loginerror", "Username does not exist!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			if(!loggedIn.getPassword().equals(password)) { //Incorrect password.
				request.setAttribute("loginerror", "Incorrect Password!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
		List<String> accountNames = new ArrayList<>(UserDB.getUser(userName).getAccounts().keySet());
		request.getSession().setAttribute("accountnames", accountNames);
		request.getSession().setAttribute("username", userName);


		// make history directory
		File dir = new File("history");

		// if the directory does not exist, create it
		if (!dir.exists()) {
			dir.mkdir();
		}

		// redirect to homepage.jsp
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.getRequestDispatcher("/WEB-INF/view/homepage.jsp").forward(request, response);
	}
}


