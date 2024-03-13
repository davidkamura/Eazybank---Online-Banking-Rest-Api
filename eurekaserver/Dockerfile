FROM eclipse-temurin:21-alpine

COPY ./target/classes/application.yaml /home
COPY ./target/eurekaserver-0.0.1-SNAPSHOT.jar /home

RUN apk update && apk upgrade
RUN apk --no-cache add curl
RUN curl --version

ENTRYPOINT ["java", "-jar", "/home/eurekaserver-0.0.1-SNAPSHOT.jar"]