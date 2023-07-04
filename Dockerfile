FROM openjdk:17-oracle
ADD build/libs/*.jar app.jar
EXPOSE 8082
CMD ["java", "-jar", "app.jar"]
