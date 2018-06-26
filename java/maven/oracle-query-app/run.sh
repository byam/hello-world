#!/usr/bin/env bash

mvn compile exec:java -Dexec.mainClass=com.oracle_query.app.JavaDataAccess \
    -Dexec.cleanupDaemonThreads=false -Djava.security.egd=file:/dev/../dev/urandom \
    -Doracle.net.tns_admin=src/main/resources/
#    -Doracle.net.tns_admin=/Users/01014477/git/byam/hello-world/java/maven/oracle-query-app/

