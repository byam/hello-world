
## Reference
- [Get Oracle JDBC drivers and UCP from Oracle Maven Repository ](https://blogs.oracle.com/dev2dev/get-oracle-jdbc-drivers-and-ucp-from-oracle-maven-repository-without-ides)

## Create project

```bash
# create project
$ mvn archetype:generate -DgroupId=com.oracle_query.app -DartifactId=oracle-query-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

# check
$ mvn compile exec:java -Dexec.mainClass=com.oracle_query.app.App
```

## Add Oracle JDBC

#### Create a settings-security.xml
```bash
# create master password
$ mvn -encrypt-master-password HOGEHOGE
  {o+k/VW755WcHs+uCMAqFwHb5XQ2PAH7qEvjujhcSE6A=}

# add it to maven security file
$ cat ~/.m2/settings-security.xml 
<settingsSecurity>
<master>{o+k/VW755WcHs+uCMAqFwHb5XQ2PAH7qEvjujhcSE6A=}
</settingsSecurity>
``` 

#### Create a settings.xml file

Login to http://maven.oracle.com/ and create user.

```bash
## encrypt password
$ mvn -encrypt-password PASSWORD             
  {F5dEO8mQvjkHSq3WuKitTH8vLdLVliHJeTWgt/FVPuI=}

## create config file with USER_NAME and ENCRYPTED PASSWORD
$ cat ~/.m2/settings.xml
<settings>

 <servers>
 <server>
    <id>maven.oracle.com</id>
    <username>USER_NAME</username>
    <password>{F5dEO8mQvjkHSq3WuKitTH8vLdLVliHJeTWgt/FVPuI=}</password>
    <configuration>
      <basicAuthScope>
        <host>ANY</host>
        <port>ANY</port>
        <realm>OAM 11g</realm>
      </basicAuthScope>
      <httpConfiguration>
        <all>
          <params>
            <property>
              <name>http.protocol.allow-circular-redirects</name>
              <value>%b,true</value>
            </property>
          </params>
        </all>
      </httpConfiguration>
    </configuration>
  </server>
  </servers>

</settings>
```

#### Adding JDBC driver to pom.xml

```xml
<dependencies>
  <dependency>
    <groupId>com.oracle.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>12.2.0.1</version>
  </dependency>
</dependencies>
<repositories>
  <repository>
    <id>maven.oracle.com</id>
    <name>oracle-maven-repo</name>
    <url>https://maven.oracle.com</url>
    <layout>default</layout>
    <releases>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </releases>
  </repository>
</repositories>
<pluginRepositories>
  <pluginRepository>
    <id>maven.oracle.com</id>
    <name>oracle-maven-repo</name> 
    <url>https://maven.oracle.com</url>
    <layout>default</layout>
    <releases>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </releases>
  </pluginRepository>
</pluginRepositories>
```

#### Download the Oracle Driver

```bash
$ mvn compile exec:java -Dexec.mainClass=com.oracle_query.app.App
```

## Run simple SQL

* Create Java file
```java
package com.oracle_query.app;

import java.sql.*;
import java.util.TimeZone;

public class JdbcOracle {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException {

        // Set timezone
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");
        TimeZone.setDefault(timeZone);

        try{
            // Returns the Class object associated with the class
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException exception) {
            System.out.println("Oracle Driver Class Not found Exception: " + exception.toString());
        }

        // Set connection timeout. Make sure you set this correctly as per your need
        DriverManager.setLoginTimeout(5);
        System.out.println("Oracle JDBC Driver Successfully Registered! Let's make connection now");

        try {
            // Attempts to establish a connection
            // here DB name: localhost, sid: crunchify
            connection = DriverManager.getConnection("jdbc:oracle:thin:@HOST:PORT/service", "USER", "PASSWORD");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        // Creates a Statement object for sending SQL statements to the database
        statement = connection.createStatement();

        // Executes the given SQL statement, which returns a single ResultSet object
        resultSet = statement.executeQuery("QUERY");

        if (resultSet.next()) {
            System.out.println("[Success result]:" + resultSet.getString(1));
        } else {
            throw new SQLException("Can NOT retrieve Employee details from table");
        }

        System.out.println("Oracle JDBC connect and query test completed.");
    }
}
```


* Run maven
```bash
$ mvn compile exec:java -Dexec.mainClass=com.oracle_query.app.JdbcOracle -Dexec.cleanupDaemonThreads=false -Djava.security.egd=file:/dev/../dev/urandom
```
