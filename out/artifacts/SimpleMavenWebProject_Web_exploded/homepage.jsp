<!-- SimpleAdder.html -->

<HTML>
<HEAD>
    <META HTTP-EQUIV="ContentType"  CONTENT="text/HTML">
    <META HTTP-EQUIV ="Pragma"  CONTENT="no cache">
    <META HTTP-EQUIV ="Cache-control"  CONTENT="no cache">
    <META HTTP-EQUIV ="Expires"  CONTENT="0">

    <TITLE>Wells Cargo</TITLE>
<HEAD>

<BODY>

<h1> View Summary:</h1>
<FORM  METHOD=POST  ACTION="/ViewSummaryServlet">
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "View Balance"></TD>
</FORM>
<BR><BR>

<h1> Withdraw Money:</h1>
<FORM  METHOD=POST  ACTION="/WithdrawMoneyServlet">
    <TABLE>
        <TR>
            <TD>$ Amount:</TD>
            <TD><INPUT  TYPE="Number"  NAME="amount"  VALUE=""  SIZE=10></TD>
        </TR>
        <TR>
            <TD>Account:</TD>
            <TD><select name="accountname" value=""> </select></TD>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR><BR>

<h1> Deposit Money:</h1>
<FORM  METHOD=POST  ACTION="/DepositMoneyServlet">
    <TABLE>
        <TR>
            <TD>$ Amount:</TD>
            <TD><INPUT  TYPE="Number"  NAME="amount"  VALUE=""  SIZE=10></TD>
        </TR>
        <TR>
            <TD>Account:</TD>
            <TD><select name="accountname" value=""> </select></TD>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR><BR>

<h1> Transfer Money:</h1>
<FORM  METHOD=POST  ACTION="/TransferMoneyServlet">
    <TABLE>
        <TR>
            <TD>$ Amount:</TD>
            <TD><INPUT  TYPE="Number"  NAME="amount"  VALUE=""  SIZE=10></TD>
        </TR>
        <TR>
            <TD>From:</TD>
            <TD><select name="sourceAccount" value=""> </select></TD>
        </TR>
        <TR>
            <TD>To:</TD>
            <TD><select name="targetAccount" value=""> </select></TD>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR><BR>

<h1> Create New Account:</h1>
<FORM  METHOD=POST  ACTION="/NewAccountServlet">
    <TABLE>
        <TR>
            <TD>$ Account Type:</TD>
            <select name="accountType" value=""> </select></TD>
        </TR>
        <TR>
            <TD>Account Name:</TD>
            <TD><INPUT  TYPE="Text"  NAME="accountType"  VALUE=""  SIZE=15></TD>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>



</BODY>
</HTML>
