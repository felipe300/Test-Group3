<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOROSCOPO CHINO</title>
<link rel="stylesheet" href="css/style.css">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">BIENVENIDO AL HOROSCOPO CHINO EN JAVA 2020</h5>
            
            <form class="form-signin" method="post" action="login.jsp">
              <button id="btnLogin" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">INICIAR SESION</button>
            </form>
            <hr class="my-4">
            <form class="form-signin" method="post" action="register.jsp">
              <button id="btnLogin" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">REGISTRARSE</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>