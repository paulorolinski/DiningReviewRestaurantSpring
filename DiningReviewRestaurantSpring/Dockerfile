# Etapa de build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests -Dmaven.test.skip=true

# Etapa de execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/DiningReviewRestaurantSpring-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
