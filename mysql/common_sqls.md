# Common SQLs

## Create Table
```sql
mysql> CREATE TABLE mytable (
  name VARCHAR(32),
  age INT(16),
  update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

mysql> SHOW COLUMNS FROM mytable;
+-----------+-------------+------+-----+-------------------+-------+
| Field     | Type        | Null | Key | Default           | Extra |
+-----------+-------------+------+-----+-------------------+-------+
| name      | varchar(32) | YES  |     | NULL              |       |
| age       | int(16)     | YES  |     | NULL              |       |
| update_at | timestamp   | NO   |     | CURRENT_TIMESTAMP |       |
+-----------+-------------+------+-----+-------------------+-------+

mysql> INSERT INTO mytable
          (name, age)
       VALUES
          ("user1", 11),
          ("user2", 12),
          ("user3", 13);

mysql> SELECT * FROM mytable;
       +-------+------+---------------------+
       | name  | age  | update_at           |
       +-------+------+---------------------+
       | user1 |   11 | 2018-05-13 04:23:03 |
       | user2 |   12 | 2018-05-13 04:23:03 |
       | user3 |   13 | 2018-05-13 04:23:03 |
       +-------+------+---------------------+
```

## Create Database

```sql
CREATE DATABASE IF NOT EXISTS DBName;


CREATE TABLE euc_mp.j_rsv (
  rsv_no VARCHAR(32),
  yad_no VARCHAR(32)
  );
```