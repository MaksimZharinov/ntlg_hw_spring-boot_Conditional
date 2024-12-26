FROM alpine:latest

RUN apk update && apk add openjdk17-jre-headless && apk upgrade

ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
ENV PATH="$JAVA_HOME/bin:$PATH"

WORKDIR /testContainerApp

EXPOSE 8080

ADD target/ntlg_hw_spring-boot_Conditional-0.0.1-SNAPSHOT.jar testContainersApp.jar

ENTRYPOINT ["java", "-jar", "testContainersApp.jar"]