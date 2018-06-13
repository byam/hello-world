#!/usr/bin/env bash

ENV="test"
JOB_NAME_PREFIX="${ENV}-dataflow-jln-stock"
GOOGLE_PROJECT="rls-jln-zam"
NOW=$(date +'%Y%m%d%H%M%S')
NUM_WORKERS=1


mvn compile exec:java \
  -Dexec.mainClass=com.jdbcio.app.Main \
  -Dexec.args="\
  --runner=DataflowRunner \
  --jobName=${JOB_NAME_PREFIX}-${NOW} \
  --project=${GOOGLE_PROJECT} \
  --stagingLocation=gs://${GOOGLE_PROJECT}-dev-dataflow/${JOB_NAME_PREFIX}/staging \
  --tempLocation=gs://${GOOGLE_PROJECT}-dev-dataflow/${JOB_NAME_PREFIX}/tmp \
  --autoscalingAlgorithm=NONE \
  --numWorkers=${NUM_WORKERS} \
  --workerMachineType=n1-standard-2 \
  --network=rls-jln-zam01 \
  --subnetwork=regions/asia-northeast1/subnetworks/rls-jln-zam-subnet01 \
  --region=asia-northeast1 \
  " \
  -Dexec.cleanupDaemonThreads=false \
  -Djava.security.egd=file:/dev/../dev/urandom
