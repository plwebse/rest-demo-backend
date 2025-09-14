FROM maven:3.9.11-amazoncorretto-17-alpine AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests


FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/rest-demo-backend-0.0.1-SNAPSHOT.jar .

# COPY target/rest-demo-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","rest-demo-backend-0.0.1-SNAPSHOT.jar"]