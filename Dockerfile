FROM openjdk:22-jdk
WORKDIR /app
COPY target/quiz-app.jar quiz-app.jar
CMD ["java", "-jar", "quiz-app.jar"]