<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!-- SimpleAdder.html -->

<HTML>
<HEAD>
    <META HTTP-EQUIV="ContentType"  CONTENT="text/HTML">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />


    <TITLE>Wells Cargo</TITLE>
<HEAD>

<BODY>
<h1 style="text-align: center; background-color: #8B0000; color: goldenrod">Wells Cargo</h1>
<%
    List<String> accountNames = (List<String>) request.getSession().getAttribute("accountnames");
    List<String> accountTypes = (List<String>) request.getSession().getAttribute("accounttypes");
%>
<%
    String username = (String) request.getSession().getAttribute("username");
    if(!(username == null || username.equals(""))) {
%>
<FORM  METHOD=POST  ACTION="/Logout">
    <INPUT  TYPE="Submit"  VALUE = "Logout"></TD>
</FORM>
<%
    }
%>
<BR>
<FORM  METHOD=POST  ACTION="/Summary">
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "View Balance Summary"></TD>
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
<h1> View Account History:</h1>
<BR>
<FORM  METHOD=POST  ACTION="/History">
    <TR>
        <TD>Account:</TD>
        <%
            if(accountNames == null || accountNames.isEmpty()){
        %>
        <TD><h4>Accounts you create will appear here.</h4><TD>
            <%
                    }
                    else{
                %>
        <TD><select name="accountname" value="">
            <%
                for(String account : accountNames){
            %>
            <option> <%=account%> </option>
            <%
                }
            %>
        </select></TD>
        <%
            }
        %>
    </TR>
    <BR><BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>
</FORM>
<BR>
<%
    String viewHistoryResponse = (String) request.getAttribute("viewhistory");
    if(!(viewHistoryResponse == null || viewHistoryResponse.isEmpty())) {
%>
<h2><%=viewHistoryResponse%></h2>
<%
    }
%>
<BR>
<h1> Withdraw Money:</h1>
<FORM  METHOD=POST  ACTION="/Withdraw">
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
            <TD><h4>Accounts you create will appear here.</h4><TD>
                <%
                    }
                    else{
                %>
            <TD><select name="accountname" value="">
                <%
                        for(String account : accountNames){
                %>
                <option> <%=account%> </option>
                <%
                        }
                %>
            </select></TD>
            <%
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
<FORM  METHOD=POST  ACTION="/Deposit">
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
            <TD><h4>Accounts you create will appear here.</h4><TD>
            <%
            }
            else{
            %>
            <TD><select name="accountname" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
                <%
                    }
                %>
            </select></TD>
            <%
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
    String depositResponse = (String) request.getAttribute("depositmoney");
    if(!(depositResponse == null || depositResponse.isEmpty())) {
%>
<h2><%=depositResponse%></h2>
<%
    }
%>
<BR>

<h1> Transfer Money:</h1>
<FORM  METHOD=POST  ACTION="/Transfer">
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
            <TD><h4>Accounts you create will appear here.</h4><TD>
            <%
            }
            else{
            %>
            <TD><select name="sourcename" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
                <%
                    }
                %>
            </select></TD>
            <%
                }
            %>
        </TR>
        <TR>
            <TD>To Account:</TD>
            <%
                if(accountNames == null || accountNames.isEmpty()){
            %>
            <TD><h4>Accounts you create will appear here.</h4><TD>
            <%
            }
            else{
            %>
            <TD><select name="targetname" value="">
                <%
                    for(String account : accountNames){
                %>
                <option> <%=account%> </option>
                <%
                    }
                %>
            </select></TD>
            <%
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
    String transferMoneyResponse = (String) request.getAttribute("transfermoney");
    if(!(transferMoneyResponse == null || transferMoneyResponse.isEmpty())) {
%>
<h2><%=transferMoneyResponse%></h2>
<%
    }
%>
<BR>

<h1> Create New Account:</h1>
<FORM  METHOD=POST  ACTION="/NewAccount">
    <TABLE>
        <TR>
            <TD>Account Type:</TD>
            <TD><select name="accounttype" value="">
                <%
                    for(String account : accountTypes){
                %>
                <option value="<%=account%>"> <%=account%> </option>
                <%
                    }
                %>
            </select></TD>

        </TR>
        <TR>
            <TD>Account Name:</TD>
            <TD><INPUT  TYPE="Text"  NAME="accountname"  VALUE=""  SIZE=15></TD>
        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR>
<%
    String newAccountResponse = (String) request.getAttribute("newaccount");
    if(!(newAccountResponse == null || newAccountResponse.isEmpty())) {
%>
<h2><%=newAccountResponse%></h2>
<%
    }
%>
<BR>


<h1> Delete an Account:</h1>
<FORM  METHOD=POST  ACTION="/DeleteAccount">
    <TABLE>
        <TR>
            <TD>Account Name:</TD>
            <TD><select name="accountname" value="">
                <%
                    for(String account : accountNames){
                %>
                <option value="<%=account%>"> <%=account%> </option>
                <%
                    }
                %>
            </select></TD>

        </TR>
    </TABLE>
    <BR>
    <INPUT  TYPE="Submit"  VALUE = "Submit"></TD>
    <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

</FORM>
<BR>
<%
    String deleteAccountResponse = (String) request.getAttribute("deleteaccount");
    if(!(deleteAccountResponse == null || deleteAccountResponse.isEmpty())) {
%>
<h2><%=deleteAccountResponse%></h2>
<%
    }
%>
<BR>

</BODY>
</HTML>
