FROM openjdk:17-jdk-slim

ADD /build/libs/application.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar