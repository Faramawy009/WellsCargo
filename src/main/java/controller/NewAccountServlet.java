package controller;

import model.Account;
import model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewAccountServlet extends HttpServlet
{

	@Override
	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String username = (String)request.getSession().getAttribute("username");
		if (username == null || username.equals("")){
			request.setAttribute("loginerror", "Please login to continue!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		String accName = (String) request.getParameter("accountname");
		String accType = (String) request.getParameter("accounttype");
		Account.AccountType accountType = null;
		try {
			accountType = Account.AccountType.valueOf(accType);
		} catch (Exception e) {
			request.setAttribute("newaccount", "Invalid Request!");
			request.getRequestDispatcher("/WEB-INF/view/homepage.jsp").forward(request, response);
			return;
		}
		boolean transactionComplete = UserDB.addAccount(username, accName, accountType);
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);

		List<String> accountNames = new ArrayList<>(UserDB.getUser(username).getAccounts().keySet());
		request.getSession().setAttribute("accountnames", accountNames);

		if(transactionComplete) {
			request.setAttribute("newaccount", "You have added a new account: " + accName);
		}
		else {
			request.setAttribute("newaccount", "Account name already exists!");
		}
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

    String historyFileName = "./history/"+username+"-"+accName;
		File file = new File(historyFileName);
		file.createNewFile();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.getRequestDispatcher("/WEB-INF/view/homepage.jsp").forward(request, response);
	}

}
