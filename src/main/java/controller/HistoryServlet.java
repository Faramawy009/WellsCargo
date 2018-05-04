package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryServlet extends HttpServlet
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

		String accName = (String) request.getParameter("accountname");
		String filePath = "./history/"+username+"-"+accName;
		StringBuilder history = new StringBuilder();
		history.append("Account " + accName + " History: <BR>");
		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null)
			{
				history.append(sCurrentLine).append("<BR>");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("viewhistory", history.toString());
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.getRequestDispatcher("/WEB-INF/view/homepage.jsp").forward(request, response);
	}

}
