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
                <div class="form-group">
                    <input type="text" id="myInput" class="form-control" onkeyup="myFunction()" placeholder="Filter Search Results" title="Type in a card" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
            </div>
            <div class="row">
                    <c:choose>
                        <c:when test="${!empty(places)}">
                            <table id="myTable" class="table table-dark table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Price</th>
                                        <th>Available</th>
                                    </tr>
                                </thead>
                                <c:forEach var="place" items="${places}">
                                    <tr>
                                        <td class="tbColumns">${place.id}</td>
                                        <td class="tbColumns">${place.name}</td>
                                        <td class="tbColumns">${place.description}</td>
                                        <td class="tbColumns">${place.price}</td>
                                        <td class="tbColumns">${place.availableLots}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <p class="validations">No favorites exist for this user</p>
                        </c:otherwise>
                    </c:choose>
            </div>
            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>

        <script>
            function myFunction() {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                for (i = 1; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];

                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>
    </body>
</html>


