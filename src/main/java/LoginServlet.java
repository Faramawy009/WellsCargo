import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{

	@Override
	public void init() throws ServletException {
		try {
			UserDB.readDB("Users.db");
		} catch (Exception e) {
		e.printStackTrace();
			System.out.println("No DB Found!\n\n");
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
				sendPage(response, "The requested account does not exist");
				return;
			}
			if(!loggedIn.getPassword().equals(password)) { //Incorrect password.
				sendPage(response, "Incorrect Password");
				return;
			}
		List<String> accountNames = new ArrayList<>(UserDB.getUser(userName).getAccounts().keySet());
		request.getSession().setAttribute("accountnames", accountNames);

		request.getSession().setAttribute("username", userName);
			// redirect to homepage.jsp
			request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
//			sendValidPage(userName, response);
	}

	private void sendPage(HttpServletResponse reply,String result)
					throws IOException
	{
		reply.setContentType("text/HTML");

		PrintWriter out = reply.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Result</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<BR><BR><BR>");
		out.println("<CENTER><H1>" + result + "</H1></CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
	}
}


