#!/bin/bash

# Build the Spring Boot application
./mvnw clean package -DskipTests

# Copy the generated JAR file to the deployment directory
cd /home/adminreg/deployment/reg2024-be
docker compose down
cd /home/adminreg/reg2024/reg-be
cp target/reg-0.0.1-SNAPSHOT.jar /home/adminreg/deployment/reg2024-be
cd /home/adminreg/deployment/reg2024-be
docker compose up -d --build