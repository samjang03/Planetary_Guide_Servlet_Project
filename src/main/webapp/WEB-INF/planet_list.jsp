<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Planet List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style><%@include file="/WEB-INF/css/styles.css"%></style>
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
			<h3 class="text-center">List of Planets</h3>
			<hr>
			<div class="container text-left">

			<c:if test="${sessionScope.role == 'admin'}">
            <form action="add_new" method="post">
				<input type="hidden" name="action" value="add_planet"/>
                <button class="btn btn-outline-warning" type="submit">Add New Planet</button>
            </form>
            </c:if>

			</div>
			<br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Radius</th>
						<th>Mean temperature</th>
						<th>Atmosphere</th>
						<th>Life</th>
						<th>Galaxy</th>
						<c:if test="${planetMap != null}">
                        <th>Number of Satellites</th>
                        </c:if>
						<c:if test="${sessionScope.role == 'admin'}">
						<th>Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>

				    <c:if test="${planetMap != null}">
                    	<c:forEach items="${planetMap}" var="entry">
                         <!--key = "${entry.key}", value = "${entry.value}"-->
                         <tr>
                            <td><c:out value="${entry.key.id}" /></td>
                         	<td><c:out value="${entry.key.name}" /></td>
                         	<td><c:out value="${entry.key.radius}" /></td>
                         	<td><c:out value="${entry.key.meanTemperature}" /></td>
                         	<td><c:out value="${entry.key.atmosphere}" /></td>
                         	<td><c:out value="${entry.key.life}" /></td>
                         	<td><c:out value="${entry.key.galaxy}" /></td>
                         	<td><c:out value="${entry.value}" /></td>
                         </tr>
                         </c:forEach>

                    </c:if>

                <c:if test="${planetMap == null}">
					<c:forEach var="planet" items="${planetList}">
						<tr>
							<td><c:out value="${planet.id}" /></td>
							<td><c:out value="${planet.name}" /></td>
							<td><c:out value="${planet.radius}" /></td>
							<td><c:out value="${planet.meanTemperature}" /></td>
							<td><c:out value="${planet.atmosphere}" /></td>
							<td><c:out value="${planet.life}" /></td>
							<td><c:out value="${planet.galaxy}" /></td>
							<c:if test="${sessionScope.role == 'admin'}">
							<td><a href="edit_planet?id=<c:out value='${planet.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete_planet?id=<c:out value='${planet.id}' />">Delete</a></td>
							</c:if>
						</tr>
					</c:forEach>
			    </c:if>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>