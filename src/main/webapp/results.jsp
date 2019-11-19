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
           <!-- </div>
            <div class="row"> -->
               <!-- <div class="column">
                    <img id="parkingLotImage" src="images/compactParking.jpg" class="parkingLot" alt="image of parking lot"/>
                </div> -->
                <c:choose>
                    <c:when test="${!empty(lots)}">
                        <table id="myTable" class="table table-dark table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Available</th>
                                <th>Favorite</th>
                            </tr>
                            </thead>
                            <c:forEach var="lot" items="${lots}">
                                <tr>
                                    <td class="tbColumns">${lot.id}</td>
                                    <td class="tbColumns">${lot.name}</td>
                                    <td class="tbColumns">${lot.description}</td>
                                    <td class="tbColumns">${lot.price}</td>
                                    <td class="tbColumns">${lot.availableLots}</td>
                                    <td class="tbColumns"><a href="addFavorite?param=${lot.id}">Add</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p class="validations">No parkings were found</p>
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
                    td = tr[i].getElementsByTagName("td")[1];

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


