<!-- SimpleAdder.html -->

<HTML>
<HEAD>

    <META  HTTP-EQUIV="ContentType"  CONTENT="text/HTML">
    <META HTTP-EQUIV ="Pragma"  CONTENT="no cache">
    <META HTTP-EQUIV ="Cache-control"  CONTENT="no cache">
    <META HTTP-EQUIV ="Expires"  CONTENT="0">

    <TITLE>Wells Cargo</TITLE>
    <HEAD>

<BODY>

    <h1> Existing User</h1>
    <FORM  METHOD=POST  ACTION="/LoginServlet/Login">

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

    <FORM  METHOD=POST  ACTION="/RegisterServlet/Register">

        <TABLE>
            <TR>
                <TD>User Name:</TD>
                <TD><INPUT  TYPE="Text"  NAME="username"  VALUE=""  SIZE=5></TD>
            </TR>
            <TR>
                <TD>Password:</TD>
                <TD><INPUT  TYPE="Text"  NAME="password"  VALUE=""  SIZE=5></TD>
            </TR>
        </TABLE>
        <BR>
        <INPUT  TYPE="Submit"  VALUE = "Register"></TD>
        <INPUT  TYPE="Reset"  VALUE="Clear"></TD>

    </FORM>

</BODY>
</HTML>
