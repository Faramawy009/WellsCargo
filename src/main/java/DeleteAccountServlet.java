import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteAccountServlet extends HttpServlet
{

	@Override
	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String username = (String)request.getSession().getAttribute("username");
		if (username == null || username.equals("")){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		String accName = (String) request.getParameter("accountname");
		if (UserDB.getUser(username).getAccounts().get(accName).getBalance() != 0){

			request.setAttribute("deleteaccount", "Error...Account Not Empty !!");
			request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
			return;
		}

		UserDB.removeAccount(username, accName);
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		List<String> accountNames = new ArrayList<>(UserDB.getUser(username).getAccounts().keySet());
		request.getSession().setAttribute("accountnames", accountNames);
		request.setAttribute("viewsummary", summary);
		request.setAttribute("deleteaccount", "Account " + accName + " was deleted");
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
