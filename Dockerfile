FROM maven:3.8.4-openjdk-17

COPY src /app/src
COPY pom.xml .


WORKDIR /app

RUN ["/app/mvnw", "dependency:go-offline"]

COPY ./target/kodominio-0.0.1-SNAPSHOT.jar /app

RUN ["/app/mvnw", "package", "-DskipTests"]

EXPOSE 8080

CMD ["java", "-jar", "target/kodominio.jar"]