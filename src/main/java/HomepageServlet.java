import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
				import javax.servlet.*;
				import javax.servlet.http.*;

public class HomepageServlet extends HttpServlet
{

	@Override
	public void init() throws ServletException {
		super.init();

	}

	@Override
	public void doGet(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String username = (String) request.getAttribute("username");
		if(username == null){
			sendPage(response,"please log in.");
			return;
		}

	}

	@Override
	public void doPost(HttpServletRequest request,
										 HttpServletResponse response)
					throws IOException,ServletException
	{
		String username = (String) request.getAttribute("username");
		if(username == null){
			sendPage(response,"please log in.");
			return;
		}

		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
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