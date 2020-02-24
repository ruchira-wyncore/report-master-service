FROM openjdk:8-jdk-alpine
RUN apk add --no-cache bash

MAINTAINER Ruchira Biyani <rbiyani@wyncore.com>

ENV SERVER_PORT 8080
EXPOSE $SERVER_PORT

COPY target/*.jar /app.jar
COPY wrapper.sh /wrapper.sh

ENTRYPOINT ["/wrapper.sh"]




