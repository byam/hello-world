# Maven

## Resource

- [Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- [Introduction to the Maven Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

## Install

### Ubuntu

```bash
# install
$ sudo apt-get install maven

# check
$ mvn --version
```

## Create Simple Project

* Create Simple Project
```bash
mvn archetype:generate -DgroupId=com.my.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

* Check created project
```bash
tree my-app 
my-app
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── my
    │               └── app
    │                   └── App.java
    └── test
        └── java
            └── com
                └── my
                    └── app
                        └── AppTest.java
```

## Maven Phases

Although hardly a comprehensive list, these are the most common default lifecycle phases executed.

- `validate`: validate the project is correct and all necessary information is available
- `compile`: compile the source code of the project
- `test`: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
- `package`: take the compiled code and package it in its distributable format, such as a JAR.
- `integration`-test: process and deploy the package if necessary into an environment where integration tests can be run
- `verify`: run any checks to verify the package is valid and meets quality criteria
- `install`: install the package into the local repository, for use as a dependency in other projects locally
- `deploy`: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

- `clean`: cleans up artifacts created by prior builds
- `site`: generates site documentation for this project

### Examples

* Build The Project
```bash
cd my-app
mvn package
java -cp target/my-app-1.0-SNAPSHOT.jar com.my.app.App
Hello World!
```

* Compile the source code of the project
```bash
cd my-app
mvn compile exec:java -Dexec.mainClass=com.my.app.App
```
