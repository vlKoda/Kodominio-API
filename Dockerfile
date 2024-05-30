# Primeiro estágio: Compilação
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e as dependências do projeto para o container
COPY pom.xml .

# Baixa as dependências sem construir o projeto
RUN mvn dependency:go-offline

# Copia o restante do código fonte para o container
COPY src ./src

# Compila o projeto e gera o JAR
RUN mvn package -DskipTests

# Segundo estágio: Imagem final
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado no estágio de build para o diretório de trabalho
COPY --from=build /app/target/*.jar app.jar

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
