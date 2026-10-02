# Practice Ride — fare and booking design

An original 90-minute practice based on the OOP structure of the attached “Snatch A Ride” paper. The source PDF is a single question without skeleton files or a timed second part; this version has a 10-mark Task 1 and an original 5-mark extension that unlocks after 60 minutes. It is not an official NUS assessment.

Use a Mac terminal, Vim, a JDK with `javac` (Java 17 recommended), and OpenSSL. From this directory:

```sh
./start.sh
vim task1/task1.md
./test.sh 1
./time.sh
```

At or after 60 minutes, run `./unlock.sh`. This copies your current Task 1 Java files into `task2/` and reveals `task2/task2.md`. Continue in `task2/` and use `./test.sh 2`. Work only in the answer directory for each phase. Put your student number, not your name, in the `@author` tag of every Java file you change or add.

The lock is an honor-based local timer: its decryption material is present in the repo, so it cannot prevent deliberate early inspection or system clock changes. Public tests check examples and some edge cases, not design or style. No solution is included. This repository is public; keep your completed answer in a private clone if you do not want to share it.
