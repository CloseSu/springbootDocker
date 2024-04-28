FROM eclipse-temurin:22-jdk-alpine AS build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:22-jdk-alpine
VOLUME /tmp
COPY target/*.jar test-docker.jar
ENTRYPOINT ["java","-jar","/test-docker.jar"]