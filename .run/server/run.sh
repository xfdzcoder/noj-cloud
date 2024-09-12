#!/bin/bash

jar_path=$1

cd /opt/projects/NOJ

java -Dspring.config.additional-location=/opt/projects/NOJ/conf/config-dev-server.yml \
-Dlogging.config=/opt/projects/NOJ/conf/logback-spring.xml \
-jar "$jar_path"