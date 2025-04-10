# Cab Booking System - Spring Boot Microservices Project

This is a real-time cab booking system built using Spring Boot and microservices architecture. It simulates basic functionalities of platforms like Ola or Uber, with features such as user registration, cab search, ride booking, live tracking, and notifications.

---

## Features

- User registration and login
- Search for available cabs based on source and destination
- Book cabs and display cab and driver details
- Real-time cab tracking using WebSocket and Google Maps
- Notifications via SMS and email using Kafka, Twilio, and JavaMailSender
- Booking confirmation and ride fare display

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Cloud (Eureka, API Gateway, OpenFeign)
- Spring Data JPA
- MySQL
- PostgresSQL
- Apache Kafka
- WebSocket
- Google Maps JavaScript API
- JSP, HTML, CSS, Bootstrap, JavaScript
- Twilio API
- JavaMailSender

---

## Microservices Overview

1. **User Service** – Manages user registration and login
2. **Cab Service** – Stores cab and driver data and filters available cabs
3. **Booking Service** – Books selected cab and stores ride history
4. **Notification Service** – Sends SMS and email after booking confirmation
5. **API Gateway** – Common entry point for all services
6. **Eureka Server** – Service discovery for all microservices

---

## Flow of Application

1. User registers and logs in
2. Enters source and destination to find cabs
3. List of available cabs is fetched from Cab Service
4. User books a cab; Booking Service stores details
5. Kafka event is published and consumed by Notification Service
6. Notification is sent to the user
7. Ride is tracked in real-time using WebSocket and Google Maps
8. After the ride, fare is shown and user proceeds to payment

---

## Database Tables

**User Table**  
- id, name, username, email, password, mobile_no

**Cab Table**  
- id, model, license_plate, color, type, status, latitude, longitude

**Driver Table**  
- id, name, mobile_no, license_no, rating, status, cab_id

**Bookings Table**  
- id, username, cab_id, driver_name, source, destination, fare, started_on, completed_on

---

## Setup Instructions

1. Install Java 17, Maven, MySQL, Kafka and Zookeeper
2. Clone the repository
3. Configure database and API credentials in `application.properties`
4. Start Eureka Server, API Gateway, and all microservices
5. Start Kafka and Zookeeper
6. Access the application via `http://localhost:8080`

---

## Future Enhancements

- Payment integration (Razorpay, Stripe)
- Ride history for users
- Fare calculation using actual distance
- Admin dashboard for managing drivers and cabs

---

## Author

Prakriti Sharma  
Java Backend Developer  
Email: prakriti.guptta@gmail.com 
LinkedIn: https://www.linkedin.com/in/prakriti-gupta-870970188/

