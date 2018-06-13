#!/usr/bin/env bash

mvn compile exec:java \
  -Dexec.mainClass=com.jdbcio.app.App \
  -Dexec.args="\
  --runner=DirectRunner \
  " \
  -Dexec.cleanupDaemonThreads=false \
  -Djava.security.egd=file:/dev/../dev/urandom
