#!/bin/sh
/etc/init.d/sshd start
nginx
java -jar /home/testapp-1.0.0-SNAPSHOT.jar

