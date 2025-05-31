FROM  openjdk:17

EXPOSE 9090

COPY /target/Councellor-Enquiry-Portal-0.0.1-SNAPSHOT.jar  Councellor-Enquiry-Portal-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java" , "-jar" "Councellor-Enquiry-Portal-0.0.1-SNAPSHOT.jar" ]
