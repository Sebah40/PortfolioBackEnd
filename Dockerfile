FROM amazoncorretto:11-alpine-jdk
MAINTAINER Sebastian
COPY target/Sebastian-0.0.1-SNAPSHOT.jar Sebastian-app.jar
ENTRYPOINT ["java", "-jar","/Sebastian-app.jar"]