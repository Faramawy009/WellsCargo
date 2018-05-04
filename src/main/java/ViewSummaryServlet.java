import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ViewSummaryServlet extends HttpServlet
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
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);
//		request.removeAttribute("withdrawmoney");
//		request.removeAttribute("depositmoney");
//		request.removeAttribute("transfermoney");
//		request.removeAttribute("newaccount");
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
