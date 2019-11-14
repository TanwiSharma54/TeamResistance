<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="head.jsp"/>
<body>
<div class="container">
    <div class="row">
        <c:import url="header.jsp"/>
    </div>
    <div class="row">
        <c:import url="navbar.jsp"/>
    </div>
    <!-- Login start-->
    <div margin="10">
        <h2 align="center">Log In</h2>
        </br>
        </br>
        <FORM ACTION="j_security_check" METHOD="POST" align="center">
            <TABLE border="1px solid black" align="center">
                <TR>
                    <TD>User name: </TD>
                    <TD><INPUT TYPE="TEXT" NAME="j_username"> </TD>
                </TR>
                <TR>
                    <TD>Password: </TD>
                    <TD><INPUT TYPE="PASSWORD" NAME="j_password"></TD>
                </TR>
            </TABLE>
            <INPUT TYPE="SUBMIT" VALUE="Log In">
        </FORM>
    </div>
    <!-- Login-->

    <footer class="row">
        <c:import url="footer.jsp"/>
    </footer>
</div>
</body>
</html>
