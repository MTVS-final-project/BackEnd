FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY build/libs/hellocat-0.0.1-SNAPSHOT.jar /app/hellocat.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/hellocat.jar"]
