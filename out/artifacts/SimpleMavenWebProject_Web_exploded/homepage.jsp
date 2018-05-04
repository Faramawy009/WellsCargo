<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
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
<%
    List<String> accountNames = (List<String>) request.getAttribute("accountnames");
    List<String> accountTypes = (List<String>) request.getAttribute("accountypes");
%>
<h1> View Summary:</h1>
<FORM  METHOD=POST  ACTION="/ViewSummaryServlet">
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "View Balance"></TD>
</FORM>
<BR>
<%
    String viewSummaryResponse = (String) request.getAttribute("viewsummary");
    if(!(viewSummaryResponse == null || viewSummaryResponse.isEmpty())) {
%>
<h2><%=viewSummaryResponse%></h2>
<%
    }
%>
<BR>
<h1> Withdraw Money:</h1>
<FORM  METHOD=POST  ACTION="/WithdrawMoneyServlet">
    <TABLE>
        <TR>
            <TD>$ Amount:</TD>
            <TD><INPUT  TYPE="Number"  NAME="amount"  VALUE=""  SIZE=10></TD>
        </TR>
        <TR>
            <TD>Account:</TD>
                <%
                    if(accountNames == null || accountNames.isEmpty()){
                %>
                <p>Accounts you create will appear here.</p>
                <%
                    }
                    else{
                %>
            <TD><select name="accountnames" value="">
                <%
                        for(String account : accountNames){
                %>
                <option> <%=account%> </option>
            </select></TD>
            <%
                        }
                    }
            %>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR>
<%
    String withdrawMoneyResponse = (String) request.getAttribute("withdrawmoney");
    if(!(withdrawMoneyResponse == null || withdrawMoneyResponse.isEmpty())) {
%>
<h2><%=withdrawMoneyResponse%></h2>
<%
    }
%>

<BR>

<h1> Deposit Money:</h1>
<FORM  METHOD=POST  ACTION="/DepositMoneyServlet">
    <TABLE>
        <TR>
            <TD>$ Amount:</TD>
            <TD><INPUT  TYPE="Number"  NAME="amount"  VALUE=""  SIZE=10></TD>
        </TR>
        <TR>
            <TD>Account:</TD>
            <%
                if(accountNames == null || accountNames.isEmpty()){
            %>
            <p>Accounts you create will appear here.</p>
            <%
            }
            else{
            %>
            <TD><select name="accountnames" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
            </select></TD>
            <%
                    }
                }
            %>
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
            <TD>From Account:</TD>
            <%
                if(accountNames == null || accountNames.isEmpty()){
            %>
            <p>Accounts you create will appear here.</p>
            <%
            }
            else{
            %>
            <TD><select name="accountnames" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
            </select></TD>
            <%
                    }
                }
            %>
        </TR>
        <TR>
            <TD>To Account:</TD>
            <%
                if(accountNames == null || accountNames.isEmpty()){
            %>
            <p>Accounts you create will appear here.</p>
            <%
            }
            else{
            %>
            <TD><select name="accountnames" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
            </select></TD>
            <%
                    }
                }
            %>
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
            <TD><select name="accounttype" value="">
                <%
                    for(String account : accountTypes){
                %>
                <option> <%=account%> </option>
            </select></TD>
            <%
                }
            %>
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
