FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM ghcr.io/eclipse-ee4j/glassfish:7.1.0
COPY --from=build /app/target/blobsim-0.1.war /deploy/blobsim.war