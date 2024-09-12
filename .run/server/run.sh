#!/bin/bash

jar_path=$1

cd /opt/projects/NOJ

nohup java -Dspring.config.additional-location=/opt/projects/NOJ/conf/config-dev-server.yml \
-Dlogging.config=/opt/projects/NOJ/conf/logback-spring.xml \
-jar "$jar_path" > /dev/null 2>&1 &