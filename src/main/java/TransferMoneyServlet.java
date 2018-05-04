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

public class TransferMoneyServlet extends HttpServlet
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
		String source = (String) request.getParameter("sourcename");
		String target = (String) request.getParameter("targetname");
		boolean transactionComplete = UserDB.withdraw(username, source, amount);
		if (transactionComplete){
			UserDB.deposit(username, target, amount);
		}
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);
		if(transactionComplete) {
			request.setAttribute("transferred", "You have transferred $" + amount +
							" From " + source + " to " + target);
		}
		else {
			request.setAttribute("transfermoney", "Transaction failed!");
		}
//		request.removeAttribute("depositmoney");
//		request.removeAttribute("transfermoney");
//		request.removeAttribute("newaccount");
		try {
			UserDB.writeDB("Users.db");
			System.out.println("DB Written Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./history/"+username+"-"+source, true)));
			out.println("transfer: "+amount+" from: "+source+" to: "+target + "     "+dateFormat.format(date));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./history/"+username+"-"+target, true)));
			out.println("transfer: "+amount+" from: "+source+" to: "+target + "     "+dateFormat.format(date));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try(FileWriter fw = new FileWriter("./history/"+username+"-"+source, true);
//				BufferedWriter bw = new BufferedWriter(fw);
//				PrintWriter out = new PrintWriter(bw))
//		{
//			out.println("transfer: "+amount+" from: "+source+" to: "+target);
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		try(FileWriter fw = new FileWriter("./history/"+username+"-"+target, true);
//				BufferedWriter bw = new BufferedWriter(fw);
//				PrintWriter out = new PrintWriter(bw))
//		{
//			out.println("transfer: "+amount+" from: "+source+" to: "+target);
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
