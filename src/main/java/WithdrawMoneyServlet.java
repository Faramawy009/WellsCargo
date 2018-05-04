import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawMoneyServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String username = (String)request.getSession().getAttribute("username");
		if (username == null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		String reqAmount = (String)request.getParameter("amount");

		int amount = Integer.parseInt(reqAmount);
		String accName = (String) request.getParameter("accountnames");
		boolean transactionComplete = UserDB.withdraw(username, accName, amount);
		String summary = UserDB.printUserBalance(username);

		request.setAttribute("viewsummary", summary);
		if(transactionComplete) {
			request.setAttribute("withdrawmoney", "You have withdrawn $" + amount + " From the account " + accName);
		}
		else {
			request.setAttribute("withdrawmoney", "Transaction failed!");
		}
//		request.removeAttribute("depositmoney");
//		request.removeAttribute("transfermoney");
//		request.removeAttribute("newaccount");
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
