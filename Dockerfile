FROM openjdk:17-jdk-slim AS build
WORKDIR /app
LABEL authors="João Marcelo"

ENTRYPOINT ["top", "-b", "java", "-jar", "Kodominio.jar"]