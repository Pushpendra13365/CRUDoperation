FROM openjdk:17
COPY target/crud-operation-docker.jar crud-operation-docker.jar
CMD ["java","-jar", "crud-operation-docker.jar"]
EXPOSE 8080