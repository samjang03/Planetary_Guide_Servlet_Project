<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Admin panel</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<style><%@include file="/WEB-INF/css/styles.css"%></style>

	<link rel="shortcut icon" href="/WEB-INF/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/WEB-INF/favicon.ico" type="image/x-icon">
</head>

<body scroll="no" style="overflow: hidden">
<div
    class="bg-image"
    style="background-image: url('https://wallpapercave.com/wp/wp2825822.jpg');background-repeat: no-repeat; background-position: center; position: relative;">
  <header>
	<nav class="navbar navbar-light bg-warning">
        <div class="container">
            <a class="navbar-brand" href="#">Welcome back!</a>
        </div>
    </nav>
  </header>

<div class="container features">
    <div class="row d-flex justify-content-between">
        <div class="col-md-4">
        <div class="d-flex justify-content-center links">
            <a href="list_galaxies"><h3>Galaxies</h3></a>
        </div>
            <img src="https://cdn-icons-png.flaticon.com/512/2211/2211744.png" class="img-fluid">
        </div>

            <div class="col-md-4">
            <div class="d-flex justify-content-center links">
                <a href="list_planets"><h3>Planets</h3></a>
            </div>
                <img src="https://cdn-icons-png.flaticon.com/512/755/755947.png" class="img-fluid">
            </div>

                <div class="col-md-4">
                <div class="d-flex justify-content-center links">
                    <a href="list_satellites"><h3>Satellites</h3></a>
                </div>
                    <img src="https://cdn-icons-png.flaticon.com/512/3327/3327401.png" class="img-fluid">
                </div>
    </div>
</div>

</body>
</html>