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
            <FORM id="myForm" ACTION="search" METHOD="GET">

                <div class="form-group">
                    <label for="zipCode">Please Enter a zipCode</label>
                    <input type="text" class="form-control" id="zipCode" placeholder="Enter zipCode" name="zipCode" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>

                <div class="form-group">
                    <label for="radius">Please Enter a radius</label>
                    <input type="radius" class="form-control" id="radius" placeholder="Enter radius" name="radius" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button><br />
            </FORM>

            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
