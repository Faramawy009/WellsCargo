import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositMoneyServlet extends HttpServlet
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
		UserDB.deposit(username, accName, amount);
		String summary = UserDB.printUserBalance(username);

		request.setAttribute("viewsummary", summary);
		request.setAttribute("depositmoney", "You have deposited $" + amount + " to the account " + accName);

//		request.removeAttribute("withdrawmoney");
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
