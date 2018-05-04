import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//		request.removeAttribute("withdrawmoney");
//		request.removeAttribute("depositmoney");
//		request.removeAttribute("transfermoney");
		String username = (String)request.getSession().getAttribute("username");
		if (username == null || username.equals("")){
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
			request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
		}
		boolean transactionComplete = UserDB.addAccount(username, accName, accountType);
		String summary = UserDB.printUserBalance(username);
		List<String> accountNames = new ArrayList<>(UserDB.getUser(username).getAccounts().keySet());
		request.getSession().setAttribute("accountnames", accountNames);
		request.setAttribute("viewsummary", summary);
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
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
