FROM openjdk:19-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/recruitmentAssignment-0.0.1.jar recruitmentAssignment.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/recruitmentAssignment.jar"]