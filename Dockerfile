# Usar una imagen base de Java 17 slim
FROM openjdk:17-jdk-slim

# Definir el archivo JAR de la aplicación (puedes configurar el nombre según tu proyecto)
ARG JAR_FILE=target/bazar-0.0.1.jar

# Copiar el JAR construido de tu aplicación al contenedor con el nombre deseado
COPY ${JAR_FILE} app_bazar.jar

# Exponer el puerto en el que corre tu aplicación (asegúrate que coincida con el de tu aplicación Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot dentro del contenedor
ENTRYPOINT ["java", "-jar", "app_bazar.jar"]
