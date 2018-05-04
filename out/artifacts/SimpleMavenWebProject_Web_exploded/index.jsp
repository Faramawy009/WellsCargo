<!-- SimpleAdder.html -->

<HTML>
<HEAD>

    <META  HTTP-EQUIV="ContentType"  CONTENT="text/HTML">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <TITLE>Wells Cargo</TITLE>
    <HEAD>

<BODY>
    <h1 style="text-align: center; background-color: #8B0000; color: goldenrod">Wells Cargo</h1>
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
    <%
        String loginErrorResponse = (String) request.getAttribute("loginerror");
        if(!(loginErrorResponse == null || loginErrorResponse.isEmpty())) {
    %>
    <h2 style="color: red"><%=loginErrorResponse%></h2>
    <%
        }
    %>
    <BR>

    <h1> Existing User</h1>
    <FORM  METHOD=POST  ACTION="/Login">

        <TABLE>
            <TR>
                <TD>User Name:</TD>
                <TD><INPUT  TYPE="Text"  NAME="username"  VALUE=""  SIZE=5></TD>
            </TR>
            <TR>
                <TD>Password:</TD>
                <TD><INPUT  TYPE="password"  NAME="password"  VALUE=""  SIZE=5></TD>
            </TR>
        </TABLE>

        <BR>
        <INPUT  TYPE="Submit"  VALUE = "Sign in"></TD>
        <INPUT  TYPE="Reset"  VALUE="Clear"></TD>
    </FORM>
    <BR><BR><BR><BR>

    <h1> New User</h1>

    <FORM  METHOD=POST  ACTION="/Register">

        <TABLE>
            <TR>
                <TD>User Name:</TD>
                <TD><INPUT  TYPE="Text"  NAME="username"  VALUE=""  SIZE=5></TD>
            </TR>
            <TR>
                <TD>Password:</TD>
                <TD><INPUT  TYPE="password"  NAME="password"  VALUE=""  SIZE=5></TD>
            </TR>
        </TABLE>
        <BR>
        <INPUT  TYPE="Submit"  VALUE = "Register"></TD>
        <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

    </FORM>

</BODY>
</HTML>
