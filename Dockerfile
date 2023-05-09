FROM amazoncorretto:17-alpine-jdk

MAINTAINER Maci

COPY target/PortBackend-0.0.1-SNAPSHOT.jar PortBackendMM.jar

ENTRYPOINT ["java","-jar","/PortBackendMM.jar"]