FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar

CMD ["./mvnw", "spring-boot:run"]
COPY ${JAR_FILE} library-api.jar


CMD apt-get update -y

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/library-api.jar"]