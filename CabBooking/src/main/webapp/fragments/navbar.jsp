<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	.navbar {
		background-color: black;
	}
	
	.navbar-brand, .nav-link, .login-text {
		color: white !important;
	}
	
	.signup-btn {
		background-color: white;
		color: black !important;
		border: none;
	}
	
	.signup-btn:hover {
		background-color: lightgray;
		color: black;
	}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark">
		<div class="container">
			<!-- Company Name -->
			<a class="navbar-brand" href="#">Book Your Ride</a>
			<!-- Toggle Button for Mobile View -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Navbar Links -->
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mx-auto">
					<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About Us</a>
					</li>
				</ul>
				<div class="d-flex align-items-center">
					<a class="login-text me-3" href="#" title="Login">Login</a> <a
						class="btn signup-btn" href="#">Sign Up</a>
				</div>
			</div>
		</div>
	</nav>
</body>
</html>