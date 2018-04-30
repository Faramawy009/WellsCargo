public class HTMLStrings {
	public static final String MAIN_HEADER =  "<HTML>\n" +
					"<HEAD>\n" +
					"    <META HTTP-EQUIV=\"ContentType\"  CONTENT=\"text/HTML\">\n" +
					"    <META HTTP-EQUIV =\"Pragma\"  CONTENT=\"no cache\">\n" +
					"    <META HTTP-EQUIV =\"Cache-control\"  CONTENT=\"no cache\">\n" +
					"    <META HTTP-EQUIV =\"Expires\"  CONTENT=\"0\">\n" +
					"\n" +
					"    <TITLE>Wells Cargo</TITLE>\n" +
					"<HEAD>\n" +
					"\n" +
					"<BODY>";
	public static final String VIEW_BALANCE_FORM = "<h1> View Summary:</h1>\n" +
					"<FORM  METHOD=POST  ACTION=\"/ViewSummaryServlet\">\n" +
					"    <BR>\n" +
					"    <INPUT  TYPE=\"Submit\"  VALUE = \"View Balance\"></TD>\n" +
					"</FORM>\n" +
					"<BR><BR>";

	public static final String WITHDRAW_FORM_START= "<h1> Withdraw Money:</h1>\n" +
					"<FORM  METHOD=POST  ACTION=\"/WithdrawyMoneyServlet\">\n" +
					"    <TABLE>\n" +
					"        <TR>\n" +
					"            <TD>$ Amount:</TD>\n" +
					"            <TD><INPUT  TYPE=\"Number\"  NAME=\"amount\"  VALUE=\"\"  SIZE=10></TD>\n" +
					"        </TR>\n" +
					"        <TR>\n" +
					"            <TD>Account:</TD>\n" +
					"            <TD><select name=\"accountname\" value=\"\">";

	public static final String WITHDRAW_FORM_END ="</select></TD>\n" +
					"        </TR>\n" +
					"    </TABLE>\n" +
					"    <BR>\n" +
					"    <INPUT  TYPE=\"Submit\"  VALUE = \"Submit\"></TD>\n" +
					"    <INPUT  TYPE=\"Reset\"  VALUE=\"Clear\"></TD>\n" +
					"\n" +
					"</FORM>\n" +
					"<BR><BR>";

	public static final String DEPOSIT_FORM_START = "<h1> Deposit Money:</h1>\n" +
					"<FORM  METHOD=POST  ACTION=\"/DepositMoneyServlet\">\n" +
					"    <TABLE>\n" +
					"        <TR>\n" +
					"            <TD>$ Amount:</TD>\n" +
					"            <TD><INPUT  TYPE=\"Number\"  NAME=\"amount\"  VALUE=\"\"  SIZE=10></TD>\n" +
					"        </TR>\n" +
					"        <TR>\n" +
					"            <TD>Account:</TD>\n" +
					"            <TD><select name=\"accountname\" value=\"\">";

	public static final String DEPOSIT_FORM_END = "</select></TD>\n" +
					"        </TR>\n" +
					"    </TABLE>\n" +
					"    <BR>\n" +
					"    <INPUT  TYPE=\"Submit\"  VALUE = \"Submit\"></TD>\n" +
					"    <INPUT  TYPE=\"Reset\"  VALUE=\"Clear\"></TD>\n" +
					"\n" +
					"</FORM>\n" +
					"<BR><BR>";
	public static final String TRANSFER_FORM_START = "<h1> Transfer Money:</h1>\n" +
					"<FORM  METHOD=POST  ACTION=\"/TransferMoneyServlet\">\n" +
					"    <TABLE>\n" +
					"        <TR>\n" +
					"            <TD>$ Amount:</TD>\n" +
					"            <TD><INPUT  TYPE=\"Number\"  NAME=\"amount\"  VALUE=\"\"  SIZE=10></TD>\n" +
					"        </TR>\n" +
					"        <TR>\n" +
					"            <TD>From:</TD>\n" +
					"            <TD><select name=\"sourceAccount\" value=\"\">";
	public static final String TRANSFER_FORM_MID = "</select></TD>\n" +
					"        </TR>\n" +
					"        <TR>\n" +
					"            <TD>To:</TD>\n" +
					"            <TD><select name=\"targetAccount\" value=\"\">";
	public static final String TRANSFER_FORM_END = "</select></TD>\n" +
					"        </TR>\n" +
					"    </TABLE>\n" +
					"    <BR>\n" +
					"    <INPUT  TYPE=\"Submit\"  VALUE = \"Submit\"></TD>\n" +
					"    <INPUT  TYPE=\"Reset\"  VALUE=\"Clear\"></TD>\n" +
					"\n" +
					"</FORM>\n" +
					"<BR><BR>";

	public static final String ADD_ACCOUNT_FORM_START = "<h1> Create New Account:</h1>\n" +
					"<FORM  METHOD=POST  ACTION=\"/NewAccountServlet\">\n" +
					"    <TABLE>\n" +
					"        <TR>\n" +
					"            <TD>$ Account Type:</TD>\n" +
					"            <select name=\"accountType\" value=\"\">";

	public static final String ADD_ACCOUNT_FORM_END = "</select></TD>\n" +
					"        </TR>\n" +
					"        <TR>\n" +
					"            <TD>Account Name:</TD>\n" +
					"            <TD><INPUT  TYPE=\"Text\"  NAME=\"accountType\"  VALUE=\"\"  SIZE=15></TD>\n" +
					"        </TR>\n" +
					"    </TABLE>\n" +
					"    <BR>\n" +
					"    <INPUT  TYPE=\"Submit\"  VALUE = \"Submit\"></TD>\n" +
					"    <INPUT  TYPE=\"Reset\"  VALUE=\"Clear\"></TD>\n" +
					"\n" +
					"</FORM>";

	public static final String MAIN_FOOTER = "</BODY>\n" +
					"</HTML>";
}
