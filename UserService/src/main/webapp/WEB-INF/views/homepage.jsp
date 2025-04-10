<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Get a Ride Now!!!</title>
	<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<!-- Bootstrap Icons -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
		rel="stylesheet">
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Custom CSS -->
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

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="mb-3">
					<h3>Ride just a click away !!</h3>
				</div>
				<!-- Source Input -->
				<div class="mb-3">
					<input type="text" class="form-control" id="srcInpt"
						placeholder="Pickup location">
				</div>

				<!-- Reverse Icon -->
				<div class="text-center mb-3">
					<button class="btn btn-outline-secondary rounded-circle p-2"
						id="reverseButton" onclick="swapLocations()">
						<i class="bi bi-arrow-down-up"></i>
					</button>
				</div>

				<!-- Destination Input -->
				<div class="mb-3">
					<input type="text" class="form-control" id="destInpt"
						placeholder="Dropoff location">
				</div>

				<!-- See Prices Button -->
				<div class="d-grid">
					<button class="btn btn-dark" onclick="bookRides()">See
						Available Rides</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap JS -->
</body>

<script>
function swapLocations() {
  const srcInpt = document.getElementById('srcInpt');
  const destInpt = document.getElementById('destInpt');

  // Swap values
  const temp = srcInpt.value;
  srcInpt.value = destInpt.value;
  destInpt.value = temp;
}

function bookRides(){
	alert(document.getElementById('srcInpt').value)
	alert(document.getElementById('destInpt').value)
}
</script>

</html>
