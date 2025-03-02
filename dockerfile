FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY main/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]