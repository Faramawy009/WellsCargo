import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String accName = (String) request.getParameter("accountname");
		UserDB.deposit(username, accName, amount);
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");

		request.setAttribute("viewsummary", summary);
		request.setAttribute("depositmoney", "You have deposited $" + amount + " to the account " + accName);

		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./history/"+username+"-"+accName, true)));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			out.println("deposit: "+amount+" from: "+accName + "     "+dateFormat.format(date));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


//		try(FileWriter fw = new FileWriter("./history/"+username+"-"+accName, true);
//				BufferedWriter bw = new BufferedWriter(fw);
//				PrintWriter out = new PrintWriter(bw))
//		{
//			out.println("deposit: "+amount+" from: "+accName);
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
