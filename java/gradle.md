# Gradle

## HelloWorld

* Create app
```sh
gradle init --type java-application
```

* Build
```sh
gradle compileJava
```

* Run
```sh
gradle run
```

* Build jar
```sh
gradle jar

java -classpath build/libs/hello-gradle.jar hello.gradle.App
```

## Usecase

### 1. Apache Beam Run

* build.gradle
```groovy

plugins {
    id 'java'
    id 'application'
    id "org.jetbrains.intellij" version "0.4.9"
}

repositories {
    jcenter()
}

def BEAM_SDK_VERSION = '2.13.0'

dependencies {
    compile "org.apache.beam:beam-runners-direct-java:${BEAM_SDK_VERSION}"
    compile "org.apache.beam:beam-runners-google-cloud-dataflow-java:${BEAM_SDK_VERSION}"
    compile 'org.slf4j:slf4j-api:1.7.14'
    compile 'org.slf4j:slf4j-jdk14:1.7.14'
    implementation 'com.google.guava:guava:27.1-jre'
    testImplementation 'junit:junit:4.12'
}

mainClassName = 'hello.gradle.WordCount'

run {
    if (project.hasProperty('args')) {
        args project.args.split('\\s')
    }
}

jar {
    manifest {
        attributes "Main-Class" : "hello.gradle.WordCount"
    }
    from configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
}
```

run command
```sh
gradle run --args="\
    --jobName=${JOB_NAME} \
    --autoscalingAlgorithm=NONE \
    --runner=${RUNNER} \
    --project=${GOOGLE_PROJECT} \
    --stagingLocation=gs://${GOOGLE_PROJECT}-dataflow/${JOB_NAME}/staging \
    --numWorkers=${NUM_WORKERS} \
    --output=gs://${BUCKET}/test-byam/worcound \
    "
```


## Ref
- https://tech-lab.sios.jp/archives/9500
