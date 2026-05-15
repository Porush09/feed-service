# Stage 1: Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Cache dependencies to speed up Jenkins builds
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar feed-service.jar

# Expose the port from your properties
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "feed-service.jar"]