## Build & Run

```bash
# build
go build -o bin/myflag

# help
./bin/myflag -h
Usage of ./bin/myflag:
  -age int
        your graceful age
  -name string
        your wonderful name (default "stranger")

# default
2018/05/19 22:11:31 Hello stranger (0 years), Welcome to the command line world

# set values
/bin/myflag -name=Bya -age=28
2018/05/19 22:11:54 Hello Bya (28 years), Welcome to the command line world
```
