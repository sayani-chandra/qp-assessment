# Use an official JDK base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/GroceryBookingApi-0.0.1-SNAPSHOT.jar /app/grocery-booking-api.jar

# Expose the port that the application listens on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/grocery-booking-api.jar"]
