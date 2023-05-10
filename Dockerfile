FROM amazoncorretto:17-alpine-jdk

MAINTAINER Maci

COPY target/PortBackend-0.0.1-SNAPSHOT.jar PortBackendMM.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/PortBackendMM.jar"]