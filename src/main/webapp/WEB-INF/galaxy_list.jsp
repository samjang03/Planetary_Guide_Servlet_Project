<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Galaxy List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark justify-content-between"
			style="background-color: #8449b8">
			<div class="container">

                <div>
                    <a href="/PlanetaryGuide" class="navbar-brand"> Planetary Guide </a>
                </div>
                <c:if test="${sessionScope.role == 'admin'}">

                    <form class="form-inline my-2 my-lg-0" action="admin_panel" method="post">
                        <input type="hidden" name="action" value="admin_panel"/>
                        <button class="btn btn-outline-warning" type="submit">Go back</button>
                    </form>

                </c:if>
            </div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Galaxies</h3>
			<hr>
			<div class="container text-left">

			<c:if test="${sessionScope.role == 'admin'}">
            <form action="add_new" method="post">
				<input type="hidden" name="action" value="add_galaxy"/>
                <button class="btn btn-outline-warning" type="submit">Add New Galaxy</button>
            </form>
            </c:if>

			</div>
			<br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Type</th>
						<th>Diameter</th>
						<th>Distance to the Galaxy</th>
						<c:if test="${sessionScope.role == 'admin'}">
						<th>Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="galaxy" items="${galaxyList}">

						<tr>
							<td><c:out value="${galaxy.id}" /></td>
							<td><c:out value="${galaxy.name}" /></td>
							<td><c:out value="${galaxy.type}" /></td>
							<td><c:out value="${galaxy.diameter}" /></td>
							<td><c:out value="${galaxy.distanceToTheGalaxy}" /></td>
							<c:if test="${sessionScope.role == 'admin'}">
							<td><a href="edit_galaxy?id=<c:out value='${galaxy.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete_galaxy?id=<c:out value='${galaxy.id}' />">Delete</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>