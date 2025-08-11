FROM openjdk:21

WORKDIR /app

COPY *.java /app/
COPY mysql-connector-j-9.4.0.jar /app/

RUN javac -cp ".:mysql-connector-j-9.4.0.jar" *.java

CMD ["java", "-cp", ".:mysql-connector-j-9.4.0.jar", "Main"]
