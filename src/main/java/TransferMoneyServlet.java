import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferMoneyServlet extends HttpServlet
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
		String source = (String) request.getParameter("sourcename");
		String target = (String) request.getParameter("targetname");
		boolean transactionComplete = UserDB.withdraw(username, source, amount);
		if (transactionComplete){
			UserDB.deposit(username, target, amount);
		}
		String summary = UserDB.printUserBalance(username);

		request.setAttribute("viewsummary", summary);
		if(transactionComplete) {
			request.setAttribute("transferred", "You have transferred $" + amount +
							" From " + source + " to " + target);
		}
		else {
			request.setAttribute("transfermoney", "Transaction failed!");
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
