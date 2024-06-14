FROM maven:3.9.5-openjdk-21
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=buuild /target/CMPT276-A2-SNAPSHOT.jar CMPT276-A2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "CMPT-A2.jar"]