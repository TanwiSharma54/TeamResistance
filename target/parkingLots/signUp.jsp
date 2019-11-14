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
            <div class="row">
                <FORM id="myForm" ACTION="signUp" METHOD="GET">

                    <div class="form-group">
                        <label for="username">Please Enter a UserName</label>
                        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <div class="form-group">
                        <label for="password">Please Enter a Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button><br />
                </FORM>
            </div>

            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
