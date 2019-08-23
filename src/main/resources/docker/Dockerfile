FROM openjdk:8-jdk

#FROM docker.prod.walmart.com/samstechinfra/alpine-nginx-jdk:0.1.5

ARG jarFileName

#RUN ..

EXPOSE 8080 2222

COPY /src/main/resources/docker/startup.sh /home/.

RUN chmod 755 /home/startup.sh

COPY $jarFileName /home/testapp.jar

ENTRYPOINT ["/home/startup.sh"]