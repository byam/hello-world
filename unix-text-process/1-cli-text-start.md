
- [空行の除去](#空行の除去)
- [10文字以上の行](#10文字以上の行)
- [行の逆順](#行の逆順)
- [行の左右反転](#行の左右反転)

### 空行の除去

```sh
$ grep -v '^$' ex1.txt
Hi there,
This is a pen, I have a lot of free time. I'm 18 years old.
He's left for the city at 12:00. Why don't we get the tacos.
Yo quiero taco bell.

$ sed '/^$/d' ex1.txt
Hi there,
This is a pen, I have a lot of free time. I'm 18 years old.
He's left for the city at 12:00. Why don't we get the tacos.
Yo quiero taco bell.

$ awk 'NF!=0' ex1.txt
Hi there,
This is a pen, I have a lot of free time. I'm 18 years old.
He's left for the city at 12:00. Why don't we get the tacos.
Yo quiero taco bell.
```

### 10文字以上の行

```sh
$ awk "length>10" ex1.txt
This is a pen, I have a lot of free time. I'm 18 years old.
He's left for the city at 12:00. Why don't we get the tacos.
Yo quiero taco bell.
```

### 行の逆順

```sh
$ tail -r ex1.txt
Yo quiero taco bell.
He's left for the city at 12:00. Why don't we get the tacos.

This is a pen, I have a lot of free time. I'm 18 years old.

Hi there,
```

### 行の左右反転

```sh
$ rev ex1.txt
,ereht iH

.dlo sraey 81 m'I .emit eerf fo tol a evah I ,nep a si sihT

.socat eht teg ew t'nod yhW .00:21 ta ytic eht rof tfel s'eH
.lleb ocat oreiuq oY
```
