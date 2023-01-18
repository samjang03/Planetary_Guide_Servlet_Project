<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Planet</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #8449b8">
			<div>
				<a href="/PlanetaryGuide" class="navbar-brand"> Planetary Guide </a>
			</div>


		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${planet != null}">
					<form action="update_planet" method="post">
				</c:if>
				<c:if test="${planet == null}">
					<form action="insert_planet" method="post">
				</c:if>

				<caption>
					<h2>
					<c:if test="${planet != null}">
            			Edit planet
            		</c:if>
					<c:if test="${planet == null}">
            			Add planet
            		</c:if>
					</h2>
				</caption>

				<c:if test="${planet != null}">
					<input type="hidden" name="action" value="update_planet" />
				</c:if>
				<c:if test="${planet == null}">
                	<input type="hidden" name="action" value="insert_planet" />
                </c:if>


				<fieldset class="form-group">
                	<label>Code</label> <input type="text"
                	value="<c:out value='${planet.id}' />" class="form-control"
                	name="id" required="required">
            	</fieldset>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${planet.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Radius</label> <input type="text"
						value="<c:out value='${planet.radius}' />" class="form-control"
						name="radius">
				</fieldset>

				<fieldset class="form-group">
					<label>Mean Temperature</label> <input type="text"
						value="<c:out value='${planet.meanTemperature}' />" class="form-control"
						name="mean_temperature">
				</fieldset>

				<fieldset class="form-group">
                    <label>Atmosphere</label> <input type="text"
                	value="<c:out value='${planet.atmosphere}' />" class="form-control"
                	name="atmosphere">
                </fieldset>

                <fieldset class="form-group">
                    <label>Life</label> <input type="text"
                    value="<c:out value='${planet.life}' />" class="form-control"
                    name="life">
                </fieldset>

                <fieldset class="form-group">
                    <label>Galaxy Code</label> <input type="text"
                    value="<c:out value='${planet.galaxy}' />" class="form-control"
                    name="galaxy">
                </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>