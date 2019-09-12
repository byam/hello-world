Shell Tips
--

Summary
* [grep](#command-grep)
* [awk](#command-awk)
* [paste](#command-paste)
* [cut](#command-cut)
* [Arrays](#arrays)

## Command: `grep`

ref: https://www.thegeekstuff.com/2009/03/15-practical-unix-grep-command-examples/

```sh
# case insensetive and exact words
grep -t -w "the" file

# not contain
grep -iwv "that" file

# include one of words
grep -iwE "th(e|at|en|ose)" file

# Match regular expression in files
$ grep "lines.*empty" demo_file
```

* Regex
```
? The preceding item is optional and matched at most once.
* The preceding item will be matched zero or more times.
+ The preceding item will be matched one or more times.
{n} The preceding item is matched exactly n times.
{n,} The preceding item is matched n or more times.
{,m} The preceding item is matched at most m times.
{n,m} The preceding item is matched at least n times, but not more than m times.
```

## Command: `awk`

* Syntax:

```sh
awk '/search pattern1/ {Actions}
     /search pattern2/ {Actions}' file
```

* Examples
```sh
# Print the lines which matches with the pattern.
awk '/Thomas/ 
> /Nisha/' employee.txt

# Find the employees who has employee id greater than 200
awk '$1 >200' employee.txt

# Print the list of employees in Technology department
awk '$4 ~/Technology/' employee.txt

# A scored an average less than 50 => FAIL Same for B C scored an average between 60 and 80 => B D scored an average between 80 and 90 => A
awk '{avg=($2+$3+$4)/3; print $0, ":", (avg<50)?"FAIL":(avg<80)?"B":"A"}'
```


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

