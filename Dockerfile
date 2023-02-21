FROM maven:3.9.0-eclipse-temurin-19-alpine
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run