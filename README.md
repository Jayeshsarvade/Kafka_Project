# Kafka_Project
This project demonstrates the implementation of a Microservices architecture using Apache Kafka as the core messaging system. It showcases how different services can communicate asynchronously using Kafka topics to ensure loose coupling, scalability, and real-time data processing.


🔧 Tech Stack:
Java 17
Spring Boot
Apache Kafka
Spring Kafka
Maven
JUnit 5
Mockito

🧩 Key Features:
Microservice-based architecture
Kafka-based message publishing and consumption
Random location generation for delivery simulation
Real-time update stream using Kafka
Loose coupling between services
Unit testing with JUnit 5 and Mockito

🧠 Microservices Overview:
DeliveryBoy Service:
Produces location messages to a Kafka topic.
Generates random location coordinates using:
kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")");
Publishes to a Kafka topic (e.g., location-update-topic).

EndUser Service:
Subscribes to the same Kafka topic.
Consumes the location updates sent by the DeliveryBoy Service.
Simulates how an end user can track the delivery in real-time.

✅ Testing
The project includes unit tests for core components using:
JUnit 5 for writing test cases
Mockito for mocking dependencies such as Kafka producers and services
Sample test scenario:
Verifying that the DeliveryBoyService sends correct Kafka messages
Ensuring EndUserService consumes and handles location data properly
To run tests:
mvn test

[DeliveryBoy Service] --> [Kafka Topic: delivery-location-topic] --> [EndUser Service]

The DeliveryBoy generates a new random location.
That location is sent to a Kafka topic.
The EndUser listens to the topic and receives updates instantly.

🚀 Getting Started:
Start Zookeeper & Kafka
Run DeliveryBoy Service
Run EndUser Service
Check logs to see live location messages being sent and received.




