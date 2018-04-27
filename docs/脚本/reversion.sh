#!/bin/sh
echo "########################################################"
echo "#                     更改工程版本号                    #"
echo "########################################################"

export MAVEN_OPTS="-Xmx128m"
mvn versions:set

find . -name "*.versionsBackup"|xargs rm -r