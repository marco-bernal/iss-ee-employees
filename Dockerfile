FROM openjdk:8-jdk-alpine
ADD target/iss-ee-employees.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
