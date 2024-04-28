FROM eclipse-temurin:22-jdk-alpine AS build
WORKDIR /app/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src /app/src

RUN chmod +x mvnw
RUN ./mvnw install -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:22-jdk-alpine
VOLUME /tmp
COPY --from=build /app/target/test-docker.jar test-docker.jar
ENTRYPOINT ["java","-jar","test-docker.jar"]
