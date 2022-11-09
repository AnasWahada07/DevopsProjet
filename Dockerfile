FROM openjdk:8-jdk-alpine
ADD ./target/achat-1.0.jar achat.jar 
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089
#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} achat-1.0.jar
#ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
#EXPOSE 8089