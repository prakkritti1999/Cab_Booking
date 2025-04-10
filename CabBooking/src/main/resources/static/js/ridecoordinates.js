var map;
var marker;

// Initialize Google Maps
function initMap() {
	var initialPosition = { lat: 28.6139, lng: 77.2090 }; // Default Start Position (Delhi)

	map = new google.maps.Map(document.getElementById('map'), {
		center: initialPosition,
		zoom: 14
	});

	marker = new google.maps.Marker({
		position: initialPosition,
		map: map,
		title: "Your Cab",
		animation: google.maps.Animation.DROP
	});
}

// Connect WebSocket
var socket = new WebSocket("ws://localhost:9090/cab-location");

socket.onmessage = function(event) {
	var data = JSON.parse(event.data);
	console.log(data);

	// 🚨 If ride is completed, stop tracking
	if (data.status === "RIDE_COMPLETED") {
		
			Swal.fire({
			title: 'Your Ride is Completed !!',
			icon: 'success',
			confirmButtonColor: '#3085d6',
			confirmButtonText: 'Proceed to Pay &#8377; '+baseFare,
			}).then((result) => {
				if (result.isConfirmed) {	
				    $.ajax({						
						success : function(response){
		   					alert("OKAY")
						},
						error: function(xhr, status, error){
							console.error("Status: " + status);
				            console.error("Error: " + error);
				            console.error("Response: " + xhr.responseText);
						}
					});
				}
			});
		
		
		
		socket.close();
		return;
	}

	// 📍 Update Cab Location
	var newLatLng = new google.maps.LatLng(data.latitude, data.longitude);
	marker.setPosition(newLatLng);
	map.setCenter(newLatLng);
};

// Initialize Map on Page Load
window.onload = initMap;