package controller;

import model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawMoneyServlet extends HttpServlet
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

		String reqAmount = (String)request.getParameter("amount");

		int amount = Integer.parseInt(reqAmount);
		String accName = (String) request.getParameter("accountname");
		boolean transactionComplete = UserDB.withdraw(username, accName, amount);

		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);

		if(transactionComplete) {
			request.setAttribute("withdrawmoney", "You have withdrawn $" + amount + " From the account " + accName);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./history/"+username+"-"+accName, true)));
				out.println("Withdraw: "+amount+" from: "+accName + "     "+dateFormat.format(date));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("withdrawmoney", "Transaction failed!");
		}
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.getRequestDispatcher("/WEB-INF/view/homepage.jsp").forward(request, response);
	}

}
