#!/bin/bash

# Build the Spring Boot application
./mvnw clean package -DskipTests

# Copy the generated JAR file to the deployment directory
docker compose down
cp target/reg-0.0.1-SNAPSHOT.jar /home/adminreg/deployment/reg2024-be
docker compose up -d --build