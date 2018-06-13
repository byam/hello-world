## Resources

- []()

## Create project

```bash
mvn archetype:generate -DgroupId=com.jdbcio.app -DartifactId=jdbcio -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

```

## Deploy

### DirectRunner

```bash
mvn compile exec:java \
  -Dexec.mainClass=com.jdbcio.app.Main \
  -Dexec.args="\
  --runner=DirectRunner \
  " \
  -Dexec.cleanupDaemonThreads=false
```
