import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{

	@Override
	public void init() throws ServletException {
		try {
			UserDB.readDB("/home/elfar009/Users.db");
		} catch (Exception e) {
//		e.printStackTrace();
			System.out.println("No DB Found!\n\n");
		}

	}

	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{

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
			request.setAttribute("username", userName);
			// redirect to homepage.jsp
			sendValidPage(userName, response);
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

	private void sendValidPage(String username, HttpServletResponse reply)
					throws IOException
	{
		User currentUser = UserDB.getUser(username);
		reply.setContentType("text/HTML");
		PrintWriter out = reply.getWriter();
		out.println(HTMLStrings.MAIN_HEADER);
		out.println(HTMLStrings.VIEW_BALANCE_FORM);
		out.println(HTMLStrings.WITHDRAW_FORM_START);
		for(String s:currentUser.getAccounts().keySet())
			out.println("<option value="+s+" >" + s + "</option>");
		out.println(HTMLStrings.WITHDRAW_FORM_END);
		out.println(HTMLStrings.MAIN_FOOTER);
	}

}


