FROM eclipse-temurin:17

LABEL maintainer="wazardo99@gmail.com"

WORKDIR /user-service

COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

ENTRYPOINT [ "java", "-jar", "user-service.jar" ]
