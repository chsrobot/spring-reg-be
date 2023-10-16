#!/bin/bash

# Build the Spring Boot application
./mvnw clean package -DskipTests

# Copy the generated JAR file to the deployment directory
cp target/reg-0.0.1-SNAPSHOT.jar /home/adminreg/deployment/reg2024-be

# Restart the application
systemctl restart reg2024-be.service
