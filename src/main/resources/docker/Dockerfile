FROM openjdk:8-jdk

#FROM docker

#COPY ../../../

ARG jarFileName

#RUN ..

EXPOSE 8080 2222

COPY /src/main/resources/docker/startup.sh /home/.

RUN chmod 755 /home/startup.sh

COPY $jarFileName /home/testapp-1.0.0-SNAPSHOT.jar

ENTRYPOINT ["/home/startup.sh"]






