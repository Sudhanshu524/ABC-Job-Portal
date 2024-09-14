<%@page import="java.net.URI"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.IfStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

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

  <title>UpdateProfile</title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700|Poppins:400,700|Roboto:400,700&display=swap" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="/css/responsive.css" rel="stylesheet" />
<style>
input {
	width:100%;
}
</style>
</head>

<body>

  <!-- custom menu -->
  <div class="custom_menu-container">
    <div class="container">
      <div class="custom_menu">
        <ul class="navbar-nav ">
          <li class="nav-item">
          	<a class="navbar-brand" href="home">
            <img src="/images/logo.png" alt="" />
            <span>
              ABC Portal
            </span>
          </a>
          </li>
        </ul>
        <div class="user_option">
          <div class="login_btn-container">
            <a href="/">
              <button>Logout</button>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Update Profile section -->

  <section class="contact_section">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-4 offset-lg-2 col-md-5 offset-md-1">
          <h2 class="custom_heading">Your Profile</h2>
          
			    <p> 
			        <label for="id" class="id" data-icon="I">Your ID</label>
			        <input disabled id="id" name="uuId" type="text" value="${id_user}" />
			    </p>
			    <p> 
			        <label for="username" class="uname" data-icon="u">Your Username</label>
			        <input readonly id="username" name="uuUsername" required="required" type="text" value="${username}" />
			    </p>
			    <p> 
			        <label for="email" class="youmail" data-icon="e" > Your Email</label>
			        <input readonly id="email" name="uuEmail" required="required" type="email" value="${email}"/>  
			    </p>
			    <p> 
			        <label for="fName" class="youfname" data-icon="f" > Your First Name</label>
			        <input readonly id="firstName" name="uuFirstName" required="required" type="text" value="${fname}"/> 
			    </p>
			    <p> 
			        <label for="lName" class="youlname" data-icon="l" > Your Last Name</label>
			        <input readonly id="lastName" name="uuLastName" required="required" type="text" value="${lname}"/> 
			    </p>
			    <p> 
			        <label for="address" class="youaddress" data-icon="a">Your Address </label>
			        <input readonly id="address" name="uuAddress" required="required" type="text" value="${address}"/>  
			    </p>
			    <p> 
			        <label for="contact" class="youcontact" data-icon="c">Your Contact</label>
			        <input readonly id="contact" name="uuContact" required="required" type="text" pattern="^[0-9]+$" title="Input number only" value="${contact}"/>
			    </p>
			    <p class="signin button"> 
			        <a type="button" class="btn btn-info" href="update/${id_user}">
			        <button>EDIT</button>
			        </a> 
			    </p>
        </div>
        <div class="col-md-6 px-0">
          <div class="img-box">
            <img src="/images/contact.jpg" alt="" class="w-100" style="height: 820px;" />
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end contact section -->

  <!-- footer section -->
  <footer class="container-fluid footer_section">
    <p>
      &copy; 2022 All Rights Reserved 
      <a href="/">ABC Portal</a>
    </p>
  </footer>
  <!-- footer section -->

  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/circles.min.js"></script>
  <script src="js/custom.js"></script>

</body>
</html>