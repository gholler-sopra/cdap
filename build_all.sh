#!/usr/bin/env bash
export MAVEN_OPTS="-Xmx6144m"
mvn clean install -P spark1-dev,spark2-dev,templates,dist,release,deb-prepare,deb,tgz \
 -Drat.skip -Dcheckstyle.skip -Dmaven.javadoc.skip -Dmaven.source.skip -Dmaven.test.skip -Dgpg.skip \
 -DbuildNumber=42 \
 $*
