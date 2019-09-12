## `paste`

ref: http://www.theunixschool.com/2012/07/10-examples-of-paste-command-usage-in.html

> Used to merge lines of files. It is very useful for merging a single file and also for merging set of files as well. 

```sh
# Join all lines using the comma delimiter:
$ paste -d, -s file1
Linux,Unix,Solaris,HPUX,AIX

# Merge a file by pasting the data into 2 columns using a colon separator:
$ paste -d':' - - < file1
Linux:Unix
Solaris:HPUX
AIX:

# paste contents of 2 files side by side.
$ paste file1 file2
Linux   Suse
Unix    Fedora
Solaris CentOS
HPUX    OEL
AIX     Ubuntu
```
