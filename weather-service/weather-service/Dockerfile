FROM maven:3.9.5-eclipse-temurin-21-alpine

EXPOSE 8080

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "spring-boot:run", "-DskipTests=true"]

