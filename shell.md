## Command: `paste`

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

## Command: `cut`

ref: https://www.folkstalk.com/2012/02/cut-command-in-unix-linux-examples.html

```sh
# print 4th and 6th characters by position
cut -c4,6 file.txt

# print 4th to 6th characters by position
cut -c4-6 file.txt

# display range of fields
cut -d' ' -f1-3 file.txt

```


## Arrays

ref: https://www.thegeekstuff.com/2010/06/bash-array-tutorial/

```sh
# Search and Replace in an array elements

Unix=('Debian' 'Red hat' 'Ubuntu' 'Suse' 'Fedora' 'UTS' 'OpenLinux');

echo ${Unix[@]/Ubuntu/SCO Unix}

# add element
Unix=("${Unix[@]}" "AIX" "HP-UX")

# remove element
unset Unix[3]

# Remove Bash Array Elements using Patterns
declare -a patter=( ${Unix[@]/Red*/} )

# Concatenation of two Bash Arrays
UnixShell=("${Unix[@]}" "${Shell[@]}")

# Load Content of a File into an Array
filecontent=( `cat "logfile" `)
```

