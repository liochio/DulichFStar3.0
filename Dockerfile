FROM openjdk:17

WORKDIR /app

COPY target/DuLich_FStar-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
