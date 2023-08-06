FROM openjdk:17
WORKDIR /app

COPY ./target/listen-history-service-0.0.1-SNAPSHOT.jar ./target/listen-history-service-0.0.1-SNAPSHOT.jar

EXPOSE 8881

CMD ["java", "-jar", "./target/listen-history-service-0.0.1-SNAPSHOT.jar"]