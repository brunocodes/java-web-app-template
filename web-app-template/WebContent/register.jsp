<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Bruno Batista"> 
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- Title -->
    <title>Register Form</title>
    <!-- Custom styles for this template -->
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="style/pricing.css" rel="stylesheet" />
</head>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
      <h5 class="my-0 mr-md-auto font-weight-normal">Company name</h5>
      <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="index.jsp">Home</a>        
        <a class="p-2 text-dark" href="https://github.com/brunohob/java-web-app-template" target="_blank">Contribute</a>
        <a class="p-2 text-dark" href="contact.jsp">Contact</a>
      </nav>
      <a class="btn btn-outline-primary" href="register.jsp">Sign up</a>
    </div>
    
<div class="container">
	<h3 class="text-center">Register Form</h3>
	<hr>
	<br>
	<form action="ProcessInfo" method="post">
	
	<div class="form-row">
	    <div class="form-group col-md-6">
	      <label>First Name</label>
	      <input type="text" name="fname" value="${cust.fName }" class="form-control">
	    </div>	    
	    <div class="form-group col-md-6">
	      <label>Last Name</label>
	      <input type="text" name="lname" value="${cust.lName }" class="form-control">
	    </div>
	</div>	
	
	<div class="form-group">
		<label>Street</label>
		<input type="text" name="street" value="${cust.street }" class="form-control">
	</div>
	
	<div class="form-row">
	    <div class="form-group col-md-6">
	      <label>City</label>
	      <input type="text" name="city" value="${cust.city }" class="form-control">
	    </div>	    
	    <div class="form-group col-md-6">
	      <label>State</label>
	      <input type="text" name="state" value="${cust.state }" class="form-control">
	    </div>
	</div>	
	
	<div class="form-group">
		<label>Zip Code</label>
		<input type="text" name="zipcode" value="${cust.zipcode }" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Email</label>
		<input type="text" name="email" value="${cust.email }" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Password</label>
		<input type="password" name="password" value="${cust.password }" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Phone</label>
		<input type="text" name="phone" value="${cust.phone }" class="form-control">
	</div>		
		<button type="submit" class="btn btn-primary btn-block">Submit</button>	
	</form>
	
	<footer class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
          <div class="col-12 col-md">
          	<!-- Add company Logo Here -->
            <!--  <img class="mb-2" src="company-logo.svg" alt="" width="24" height="24"> -->  
            <small class="d-block mb-3 text-muted">&copy; 2018-2019</small>
          </div>
          <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Cool stuff</a></li>
              <li><a class="text-muted" href="#">Random feature</a></li>
              <li><a class="text-muted" href="#">Team feature</a></li>              
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Resource</a></li>
              <li><a class="text-muted" href="#">Resource name</a></li>
              <li><a class="text-muted" href="#">Another resource</a></li>
            </ul>
          </div>
          <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
              <li><a class="text-muted" href="#">Team</a></li>
              <li><a class="text-muted" href="#">Locations</a></li>
              <li><a class="text-muted" href="#">Privacy</a></li>
            </ul>
          </div>
        </div>	
      </footer>
	
</div>	
</body>
</html>