<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="dd" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Search</title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,700|Roboto:400,700&display=swap" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
<style>
	table {
		width:100%;
	}
	th, td {
		padding: 2px 5px;
		text-align: center;
	}
</style>
</head>
<body>
<jsp:include page="${Header}"/>
<div class="container" ng-app="tabApp">
  <div class="row" ng-controller="TabController">
    <div class="col">
			<h1>Users Details</h1>
			<p>
            	<sf:form action="userprofilesearch" method="post" modelAttribute="singleProfile">
            		<sf:input path="username" name="username" required="required" type="text" placeholder="Input username"/>
            		<button>Search</button>
            	</sf:form>
            </p>
			<Table border=5>
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Contact</th>
			<tr>
			<dd:forEach var="useR" items="${testS}">
			<tr>
				<td>${useR.username}</td>
				<td>${useR.email}</td>
				<td>${useR.firstName}</td>
				<td>${useR.lastName}</td>
				<td>${useR.address}</td>
				<td>${useR.contact}</td>
			</tr>
			</dd:forEach>
			</Table>   
  	</div>
</div>

</body>
</html>