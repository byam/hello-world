# Java

## Resources
- [How To Install Java with Apt-Get on Ubuntu 16.04](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04)

## Install Java

### Ubuntu

* Install JDK
```bash
# Install java
sudo apt-get update

# Install JRE
sudo apt-get install default-jre -y

# Install JDK
sudo apt-get install default-jdk -y

# check version
java -version
```

* Set `JAVA_HOME`
```bash
# get java path
$ sudo update-alternatives --config java
/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java

# add to /etc/environment
JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/" 

$ source /etc/environment
$ echo $JAVA_HOME
/usr/lib/jvm/java-8-openjdk-amd64/
```
