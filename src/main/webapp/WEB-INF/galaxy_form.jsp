<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Galaxy</title>
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
				<c:if test="${galaxy != null}">
					<form action="update_galaxy" method="post">
				</c:if>
				<c:if test="${galaxy == null}">
					<form action="insert_galaxy" method="post">
				</c:if>

				<caption>
					<h2>
					<c:if test="${galaxy != null}">
            			Edit galaxy
            		</c:if>
					<c:if test="${galaxy == null}">
            			Add new galaxy
            		</c:if>
					</h2>
				</caption>

				<c:if test="${galaxy != null}">
					<input type="hidden" name="action" value="update_galaxy" />
				</c:if>
				<c:if test="${galaxy == null}">
                	<input type="hidden" name="action" value="insert_galaxy" />
                </c:if>


				<fieldset class="form-group">
                	<label>Код галактики</label> <input type="text"
                	value="<c:out value='${galaxy.id}' />" class="form-control"
                	name="id" required="required">
            	</fieldset>

				<fieldset class="form-group">
					<label>Назва галактики</label> <input type="text"
						value="<c:out value='${galaxy.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Тип галактики</label> <input type="text"
						value="<c:out value='${galaxy.type}' />" class="form-control"
						name="type">
				</fieldset>

				<fieldset class="form-group">
					<label>Діаметр галактики</label> <input type="text"
						value="<c:out value='${galaxy.diameter}' />" class="form-control"
						name="diameter">
				</fieldset>

				<fieldset class="form-group">
                    <label>Відстань до Чумацького Шляху</label> <input type="text"
                	value="<c:out value='${galaxy.distanceToTheGalaxy}' />" class="form-control"
                	name="dist_to_the_planet">
                </fieldset>

				<button type="submit" class="btn btn-success">Зберегти</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>