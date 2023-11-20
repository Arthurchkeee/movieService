FROM openjdk:17
ADD target/movieDockerImage.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]