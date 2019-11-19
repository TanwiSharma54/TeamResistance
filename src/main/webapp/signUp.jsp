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
                <FORM id="myForm" ACTION="signUp" METHOD="GET">

                    <div class="form-group">
                        <label for="username">Please Enter a UserName</label>
                        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <div class="form-group">
                        <label for="password">Password
                        </label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password"
                               name="password" data-error="Please provide a password."
                               required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Retype
                            Password</label>
                        <input type="password" class="form-control" id="confirmPassword" placeholder="Re-enter password"
                               name="confirmPassword" equalTo="#password"
                               data-match="#password"
                               data-match-error="Confirmation password does not match"
                               required data-error="Please retype your password.">
                        <div class="help-block with-errors"></div>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-danger">Clear</button><br>
                </FORM>
            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
