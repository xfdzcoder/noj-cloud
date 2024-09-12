#!/bin/bash

jar_path=$1

cd /opt/projects/NOJ

java -Dspring.config.additional-location=/opt/projects/NOJ/conf/config-dev-server.yml \
-Dlogging.config=/opt/projects/NOJ/conf/logback-spring.xml \
-jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 "$jar_path"