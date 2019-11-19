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
                                        <th>Remove Favorite?</th>
                                    </tr>
                                </thead>
                                <c:forEach var="place" items="${places}">
                                    <tr>
                                        <td class="tbColumns">${place.id}</td>
                                        <td class="tbColumns">${place.name}</td>
                                        <td class="tbColumns">${place.description}</td>
                                        <td class="tbColumns">${place.price}</td>
                                        <td class="tbColumns">${place.availableLots}</td>
                                        <td class="tbColumns"><a href="removeFavorite?param=${place.id}">Remove</a></td></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <p class="validations"><h2>You do not have any items among your favorites</h2></p>
                        </c:otherwise>
                    </c:choose>
            </div>
            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>


