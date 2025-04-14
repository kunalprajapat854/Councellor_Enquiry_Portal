FROM  openjdk:17

EXPOSE 9090

COPY /target/Councellor-Enquiry-Portal.jar Councellor-Enquiry-Portal.jar

ENTRYPOINT [ "java" , "-jar" "/Councellor-Enquiry-Portal.jar" ]
