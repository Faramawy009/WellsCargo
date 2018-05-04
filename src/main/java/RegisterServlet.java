import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet
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
//		File n = new File("s");
//		ObjectInputStream ois = new ObjectInputStream(getServletContext().getResourceAsStream("/WEB-INF/Users.db"));
//		getServletContext().resou
//		try {
//			UserDB.users = (HashMap<String, User>)ois.readObject();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String userName = "";
		try
		{
			userName = request.getParameter("username");
			String password = request.getParameter("password");
			User loggedIn = UserDB.getUser(userName);
			if(loggedIn != null) { //User name already exists.
				sendPage(response, "Username already exists, please pick a different one.");
				return;
			}
			UserDB.addUser(userName,password);
		}
		catch(NumberFormatException cnfEx)
		{
			sendPage(response,"*** Invalid entry! ***");
		}
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendPage(response,"New User "+userName+" Was Successfully Created.");
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


