<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ride In Progress</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	<script type="text/javascript" src="/js/ridecoordinates.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=
						AIzaSyBOxVYff715FFP38Vmt5a_uOz5OMwaj28Y" async="true"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script>
	    var baseFare = <%= request.getAttribute("baseFare") %>;  // Fetch Fare from JSP
	</script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .ride-message {
            text-align: center;
            margin-top: 20px;
            font-size: 20px;
            font-weight: bold;
            color: #4CAF50;
        }
        .map-container {
            width: 100%;
            height: 500px;
            background-color: #e0e0e0;
            border: 2px solid #ccc;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 18px;
            font-weight: bold;
            color: #555;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <!-- 🚖 Navigation Bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	    <div class="container-fluid">
	        <a class="navbar-brand" href="#">CabBooking</a>
	        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
	            <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">  
	            <ul class="navbar-nav">
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Home</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Ride Details</a>
	                </li>
	            </ul>
	        </div>
	        <div class="d-flex mx-3">
	            <ul class="navbar-nav">
	                <li class="nav-item">
	                    <a class="nav-link text-danger" href="#">Emergency Help 🚨</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-warning" href="#">Cancel Ride ❌</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="#">Contact Driver 📞</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link text-danger" href="#">Logout</a>
	                </li>
	            </ul>
	        </div>
	    </div>
	</nav>
    <div class="container">
        <div class="ride-message">
            <p>✅ Your ride has been booked.&nbsp Details sent to the registered mobile no.</p>
            <p>Thank you for choosing us, have a great ride! 🚖</p>
        </div>
	
		<div class="my-3">
			<h5 style="color: #555;">&#127760; Live Cab Tracking Will Appear
				Here...</h5>
		</div>
		<!-- 📌 Placeholder for Google Maps (WebSocket will update this area) -->
		<div class="map-container" id="map"></div>
	</div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>