
FROM maven:3.9-eclipse-temurin-24 AS build

COPY . .

RUN mvn clean package


FROM eclipse-temurin:24-jdk

EXPOSE 8082

COPY --from=build /target/operator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
