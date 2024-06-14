FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/CMPT276-A2-0.0.1-SNAPSHOT.jar CMPT276A2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "CMPTA2.jar"]