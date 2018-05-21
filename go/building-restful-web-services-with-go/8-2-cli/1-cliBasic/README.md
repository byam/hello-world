## Install
```bash
go get github.com/urfave/cli
```

## Build & Run

```bash
# build
go build -o bin/cli

# help
./bin/mycli -h
NAME:
   mycli - A new cli application

USAGE:
   mycli [global options] command [command options] [arguments...]

VERSION:
   0.0.0

COMMANDS:
     help, h  Shows a list of commands or help for one command

GLOBAL OPTIONS:
   --name value   your wonderful name (default: "stranger")
   --age value    your graceful age (default: 0)
   --help, -h     show help
   --version, -v  print the version

# default
./bin/mycli
2018/05/19 22:18:53 Hello stranger (0 years), Welcome to the command line world

# set values
./bin/mycli -name=Bya -age=28
2018/05/19 22:19:44 Hello Bya (28 years), Welcome to the command line world
```
