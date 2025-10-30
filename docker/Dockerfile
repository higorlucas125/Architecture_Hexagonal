FROM maven:3.9.8-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests
RUN find /app -name "*.jar"   # Isso listará todos os arquivos JAR gerados

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copia o JAR gerado para dentro do container
COPY --from=builder /app/startApplication/target/startApplication-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]