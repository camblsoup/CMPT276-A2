FROM maven:3.9.5-openjdk-21
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/CMPT276A2-SNAPSHOT.jar CMPT276A2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "CMPTA2.jar"]