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
    <title>Thank you for Registering</title>
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
    <hr>
	<br>
	<h3>Thank you ${cust.fName} for your info</h3>
		<label>First Name : </label>
		${cust.fName}<br>
		
		<label>Last Name : </label>
		${cust.lName}<br>
		
		<label>Email : </label>
		${cust.email}<br>
</body>
</html>