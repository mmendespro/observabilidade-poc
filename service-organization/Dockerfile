# For Java 11, try this
FROM openjdk:17-slim-buster

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/*.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

ENV SPRING_PROFILES_ACTIVE=docker

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]