function swapLocations() {
  const srcInpt = document.getElementById('srcInpt');
  const destInpt = document.getElementById('destInpt');

  // Swap values
  const temp = srcInpt.value;
  srcInpt.value = destInpt.value;
  destInpt.value = temp;
}
function bookRides() {
    var src = document.getElementById('srcInpt').value;
    var dest = document.getElementById('destInpt').value;

    // Hide previous results
    $('#available-cabs').hide();

    $.ajax({
        url: '/book_ride/api1/getCabs',
        type: 'GET',
        data: { src: src, dest: dest },
        success: function (response) {
            console.log("Available Cabs: " + JSON.stringify(response));

            var cabsCards = '<div class="row">';

            response.forEach(function (item) {
                cabsCards += `
                <div class="col-md-4 mb-3">
                    <div class="card clickable-card" onclick="bookCab(${item.id}, '${src}', '${dest}', '${item.model}', ${item.baseFare}, '${item.color}', '${item.type}', ${item.capacity}, '${item.licensePlate}', '${item.licenseNo}', '${item.driverName}', '${item.driverPhone}')">
                        <img class="card-img-top" src="/images/suv.jpg" height="100px" width="50px" alt="Vehicle Image" style="padding: 8px;">
                        <div class="card-body">
                            <h5 class="card-title">${item.model} &nbsp;<span><i class="fa-solid fa-user"></i> ${item.capacity}</span></h5>
                            <p class="card-text">${item.type}</p>
                            <p class="card-text">&#8377; ${item.baseFare}</p>
                        </div>
                    </div>
                </div>`;
            });

            cabsCards += '</div>';

            $('#available-cabs').html(cabsCards).show();
        },
        error: function (xhr, status, error) {
            console.error("Status: " + status);
            console.error("Error: " + error);
            console.error("Response: " + xhr.responseText);
        }
    });
}

// Function to handle card click
//bookCab('${src}', '${dest}', '${item.model}', ${item.baseFare}, '${item.color}', '${item.type}', ${item.capacity}, '${item.licensePlate}', '${item.licenseNo}', '${item.driverName}', '${item.driverPhone}')">
function bookCab(cabId,src, dest, model, baseFare,color,type,capacity, lplate,lno, drivername, drivermobno) {
   
   var src = src;   var licence_no = lno; var cab_licencePlate = lplate; 
   var dest = dest;   var drivername = drivername; var driverNo = drivermobno;
   var cabmodel = model;  var cabColor = color; var cabType = type;
   var fare = baseFare;   
   
	Swal.fire({
		title: 'Do you want to book this ride ??',
		icon: 'info',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, sure',
		cancelButtonText: 'cancel!'
	}).then((result) => {
		if (result.isConfirmed) {	
		    $.ajax({
				
				url : '/book_ride/bookCabs',
				type: 'POST',
				data: {
					cab_id : cabId,
					model: model,
					user : "Prakriti",
					baseFare : baseFare,
					src: src,
					dest: dest
				},
				success : function(response){
   					sendNotification(drivername,driverNo, cabmodel,cabColor,cab_licencePlate, cabType, cabmodel, fare);
					console.log("Booking Details====="+ JSON.stringify(response))
				},
				error: function(xhr, status, error){
					console.error("Status: " + status);
		            console.error("Error: " + error);
		            console.error("Response: " + xhr.responseText);
				}
			});
		}
	});
}
function sendNotification(drivername,driverNo, cabmodel,cabColor,cab_licencePlate, cabType, cabmodel, fare)
{	
	var data = { 
			driver_name : drivername,
			driver_mobNo : driverNo,
			cabModel : cabmodel,
			cab_color : cabColor, 
			cab_plate_no : cab_licencePlate,
			baseFare : fare	
		};

	console.log("Notification to be sent==="+JSON.stringify(data))
	$.ajax({
		
		url : '/book_ride/sendNotification',
		contentType: 'application/json',
		type: 'POST',
		data : JSON.stringify(data),
		
		success : function(response){
			window.location.href = '/book_ride/ridestart';
		},
		error: function(xhr, status, error){
			console.error("Status: " + status);
		    console.error("Error: " + error);
		    console.error("Response: " + xhr.responseText);
		}		
	});
}