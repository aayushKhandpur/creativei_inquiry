#!/usr/bin/env bash
mvn clean
mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
STATUS=$?
if [ $STATUS -eq 0 ]; then
echo "Deployment Successful"
else
echo "Deployment Failed"
fi