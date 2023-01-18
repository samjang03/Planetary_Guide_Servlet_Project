<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/css/styles.css"%></style>
	<title>Home Page</title>

    <link rel="shortcut icon" href="/WEB-INF/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/WEB-INF/favicon.ico" type="image/x-icon">

	</head>
 <body scroll="no" style="overflow: hidden">
 <div
   class="bg-image"
   style="background-image: url('https://www.worldatlas.com/r/w960-q80/upload/0b/36/54/shutterstock-1512928403.jpg'); height: 100vh;">

    <header>
      <form action="sign_in" method="post">
      <div class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container d-flex justify-content-between">
          <a href="/" class="navbar-brand d-flex align-items-center">
            <strong>Planetary Guide</strong>
          </a>
          <input type="hidden" name="action" value="sign_in"/>
          <button class="btn btn-outline-warning" type="submit">Sign In</button>

        </div>
      </div>
      </form>

    </header>

        <div class="container bg-dark">

          <div class="row" style="margin-top: 50px;">
            <div class="col-md-4">
                <img class="card-img-top"
                style="height: 225px; width: 100%; margin-top: 10px; display: block;" src="https://images2.alphacoders.com/101/101692.jpg" data-holder-rendered="true">

                <form action="list_galaxies" method="post">
                    <input type="hidden" name="action" value="list_galaxies"/>
                    <button class="btn btn-outline-warning" type="submit" style="width: 350px; margin-top: 10px;">Get All Galaxies</button>
                </form>
            </div>

            <div class="col-md-4">
                <img class="card-img-top"
                style="height: 225px; width: 100%; display: block; margin-top: 10px;" src="https://www.teahub.io/photos/full/59-592068_fantasy-planets-wallpaper-galaxy-space-moon-background.jpg" data-holder-rendered="true">
                <form action="list_planets" method="post">
                    <input type="hidden" name="action" value="list_planets"/>
                    <button class="btn btn-outline-warning" type="submit" style="width: 350px; margin-top: 10px;">Get All Planets</button>
                 </form>

            </div>
            <div class="col-md-4">
                <img class="card-img-top"
                 style="height: 225px; width: 100%; display: block; margin-top: 10px;" src="https://wallpapercave.com/wp/wp2825715.jpg" data-holder-rendered="true">
                 <form action="list_satellites" method="post">
                    <input type="hidden" name="action" value="list_satellites"/>
                    <button class="btn btn-outline-warning" type="submit" style="width: 350px; margin-top: 10px;">Get All Satellites</button>
                </form>
            </div>
          </div>

          <div class="row" style="margin-top: 100px;">
            <div class="col-md-3">
                 <img class="card-img-top" data-holder-rendered="true" style="width: 100%; display: block; background-color: #faeba0"
                 src="https://wallpapercave.com/wp/wp2825762.jpg">
                 <div class="d-flex justify-content-center links">
                    <a href="first_query"><h6>Get Planets With Life</h6></a>
                 </div>
            </div>

                       <div class="col-md-3">
                             <img class="card-img-top" data-holder-rendered="true" style="width: 100%; display: block; background-color: #faeba0"
                             src="data:image/jpeg;base64,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">
                             <div class="d-flex justify-content-center links">
                                <a href="second_query"><h6>Get Satellites With Small Radius</h6></a>
                             </div>
                       </div>

                        <div class="col-md-3">
                             <img class="card-img-top" data-holder-rendered="true" style="width: 100%; display: block; background-color: #faeba0"
                             src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxBjDw62O6_3PZSYqcfXG9j2vwkwA8CcKurA&usqp=CAU">
                             <div class="d-flex justify-content-center links">
                                <a href="third_query"><h6>Get Planets With Many Satellites</h6></a>
                             </div>
                        </div>

                        <div class="col-md-3">
                              <img class="card-img-top" data-holder-rendered="true" style="width: 100%; height: 80%; display: block; background-color: #faeba0"
                              src="data:image/jpeg;base64,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"
                              <div class="d-flex justify-content-center links">
                                <a href="fourth_query"><h6>Get Planets With Plus Temperature</h6></a>
                              </div>
                        </div>
          </div>

    </div>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="../../js/vendor/popper.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.js"></script>



</html>