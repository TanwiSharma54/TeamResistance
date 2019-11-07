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

            <form class="form-check-inline" action="searchCards" method="GET" class="needs-validation" novalidate>
                <div id="mySearch" class="input-group mb-3">
                    <label for="zipCode">Please Enter a zipCode</label>
                    <input type="searchTerm" class="form-control" id="zipCode" placeholder="Enter zipCode" name="zipCode" aria-label="zipCode" aria-describedby="basic-addon2">
                    <label for="radius">Please Enter a radius</label>
                    <input type="searchTerm" class="form-control" id="radius" placeholder="Enter radius" name="radius" aria-label="radius" aria-describedby="basic-addon2">

                    <div class="input-group-append">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form><br/>

            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
