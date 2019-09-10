## 1. Empty Commit
```sh
git commit --allow-empty -m "Just build"
```

## 2. How can I reset or revert a file to a specific revision?

[ref](https://stackoverflow.com/questions/215718/how-can-i-reset-or-revert-a-file-to-a-specific-revision)

```sh
git checkout HASH -- FILE1 FILE2
```
