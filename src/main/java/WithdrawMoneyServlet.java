import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WithdrawMoneyServlet extends HttpServlet
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
		boolean transactionComplete = UserDB.withdraw(username, accName, amount);
		String summary = UserDB.printUserBalance(username);
		summary = summary.replaceAll("\n","<BR>");
		request.setAttribute("viewsummary", summary);
		if(transactionComplete) {
			request.setAttribute("withdrawmoney", "You have withdrawn $" + amount + " From the account " + accName);
		}
		else {
			request.setAttribute("withdrawmoney", "Transaction failed!");
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


		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./history/"+username+"-"+accName, true)));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			out.println("Withdraw: "+amount+" from: "+accName + "     "+dateFormat.format(date));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try(FileWriter fw = new FileWriter("./history/"+username+"-"+accName, true);
//				BufferedWriter bw = new BufferedWriter(fw);
//				PrintWriter out = new PrintWriter(bw))
//		{
//			out.println("Withdraw: "+amount+" from: "+accName);
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		request.getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
	}

}
