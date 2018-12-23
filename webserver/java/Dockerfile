FROM openjdk:8-jdk-alpine3.8

ENV DIR=/work

COPY main.java ${DIR}/main.java

WORKDIR ${DIR}

RUN javac main.java

EXPOSE 8080

CMD java Main
