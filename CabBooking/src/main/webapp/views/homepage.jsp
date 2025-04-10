<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Get a Ride Now!!!</title>
	<!-- Bootstrap CSS -->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<!-- Bootstrap Icons -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
		rel="stylesheet">
	
	<link rel="stylesheet" href="/css/availableCabs.css">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Custom CSS -->
</head>
<body>
	<jsp:include page="/fragments/navbar.jsp"></jsp:include>
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
	
	
	<div id="available-cabs">
			<!-- Available Cabs  -->
	
	</div>
	<!-- Bootstrap JS -->
	<script type="text/javascript" src="/js/cabsOptions.js"></script>
</body>


</html>
