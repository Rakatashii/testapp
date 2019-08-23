#!/bin/sh
/etc/init.d/sshd start
nginx
java -jar /home/catalog-extractor.jar
