<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Satellite</title>
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
				<c:if test="${satellite != null}">
					<form action="update_satellite" method="post">
				</c:if>
				<c:if test="${satellite == null}">
					<form action="insert_satellite" method="post">
				</c:if>

				<caption>
					<h2>
					<c:if test="${satellite != null}">
            			Edit satellite
            		</c:if>
					<c:if test="${satellite == null}">
            			Add satellite
            		</c:if>
					</h2>
				</caption>

				<c:if test="${satellite != null}">
					<input type="hidden" name="action" value="update_satellite" />
				</c:if>
				<c:if test="${satellite == null}">
                	<input type="hidden" name="action" value="insert_satellite" />
                </c:if>


				<fieldset class="form-group">
                	<label>Code</label> <input type="text"
                	value="<c:out value='${satellite.id}' />" class="form-control"
                	name="id" required="required">
            	</fieldset>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${satellite.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Radius</label> <input type="text"
						value="<c:out value='${satellite.radius}' />" class="form-control"
						name="radius">
				</fieldset>

				<fieldset class="form-group">
					<label>Distance to the planet</label> <input type="text"
						value="<c:out value='${satellite.distanceToThePlanet}' />" class="form-control"
						name="dist_to_the_planet">
				</fieldset>

				<fieldset class="form-group">
                    <label>Planet Code</label> <input type="text"
                	value="<c:out value='${satellite.planetID}' />" class="form-control"
                	name="planetID">
                </fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>