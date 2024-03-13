FROM eclipse-temurin:21-alpine

COPY ./target/classes/application.yaml /home
COPY ./target/classes/configkey.jks /home
COPY ./target/configserver-0.0.1-SNAPSHOT.jar /home
COPY opentelemetry-javaagent.jar /home

RUN apk update && apk upgrade
RUN apk --no-cache add curl
RUN curl --version

ENTRYPOINT ["java", "-jar", "/home/configserver-0.0.1-SNAPSHOT.jar"]