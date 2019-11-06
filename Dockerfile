FROM gradle:5.3.0-jdk11-slim
USER root
WORKDIR /usr/src/java-code
COPY . /usr/src/java-code/

RUN gradle :bootJar --stacktrace --scan

WORKDIR /usr/src/java-app

RUN apt install curl uuidgen -y
RUN cp /usr/src/java-code/build/libs/*.jar ./app.jar

RUN nohup bash -c "/usr/src/java-code/src/test/resources/simple-test-simulation.sh" && sleep 20
CMD ["java", "-jar", "app.jar"]

