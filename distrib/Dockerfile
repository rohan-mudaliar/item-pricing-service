# Use the official OpenJDK base image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at the specified path
COPY build/libs/ai.insight.shopper-0.0.1-SNAPSHOT.jar .

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "ai.insight.shopper-0.0.1-SNAPSHOT.jar"]
