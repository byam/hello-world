## Build & Run

```bash
# build
go build -o bin/cli

# help
./bin/cli -h 
NAME:
   cli - A new cli application

USAGE:
   cli [global options] command [command options] [arguments...]

VERSION:
   1.0

COMMANDS:
     help, h  Shows a list of commands or help for one command

GLOBAL OPTIONS:
   --save value   Should save to database (yes/no) (default: "no")
   --help, -h     show help
   --version, -v  print the version

# default
./bin/mycli
2018/05/19 22:23:36 Skipping saving to the database

# set values, save
./bin/cli --save=yes Albert 89 85 97
2018/05/19 22:23:54 Person:  Albert
2018/05/19 22:23:54 marks [89 85 97]
2018/05/19 22:23:54 Saving to the database [Albert 89 85 97]

# set values
/bin/cli Albert 89 85 97 
2018/05/19 22:24:34 Person:  Albert
2018/05/19 22:24:34 marks [89 85 97]
2018/05/19 22:24:34 Skipping saving to the database
```
