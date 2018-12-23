# Postgre SQL

## Basics

### Create Table

```sql
CREATE TABLE films (
    code        char(5) CONSTRAINT firstkey PRIMARY KEY,
    title       varchar(40) NOT NULL,
    did         integer NOT NULL,
    date_prod   date,
    kind        varchar(10),
    len         interval hour to minute
);
```

## Commands

```bash
# show tables
\dt

# show table shema
\d+ tablename

# drop table
DROP TABLE tablename
```
