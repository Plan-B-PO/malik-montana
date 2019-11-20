FROM gradle:5.3.0-jdk11-slim
USER root
WORKDIR /usr/src/java-code
COPY . /usr/src/java-code/

RUN gradle :bootJar --stacktrace --scan

WORKDIR /usr/src/java-app

RUN apt-get update && apt-get install curl uuid-runtime -y

RUN cp /usr/src/java-code/build/libs/*.jar ./app.jar

CMD ["nohup", "bash", "-c", "/usr/src/java-code/src/test/resources/simple-test-simulation.sh", "sleep", "10"]

CMD ["java", "-jar", "app.jar"]

