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
            <h5 class="card-title text-center">HOROSCOPO CHINO</h5>
            <form class="form-signin" method="post" action="registerUser">
              <div class="form-label-group">
                <input type="text" name="name" id="inputName" class="form-control" placeholder="nombre" required>
                <label for="inputName">Nombre</label>
              </div>             
              <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="email" required>
                <label for="inputEmail">Email</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="contraseņa" required>
                <label for="inputPassword">Contraseņa</label>
              </div>
              <button id="btnRegister" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrarse</button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>