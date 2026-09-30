# Practice C — Campus shuttle

An original 90-minute, 15-mark practice PE adapted from the bus theme in the attached Practice C paper. It is not an official NUS paper or a copy of the 40-mark, 120-minute source assessment.

Task 1 is 10 marks. At 60 minutes, Task 2 unlocks for the final 30 minutes and extends your Task 1 bus code. Work in a terminal with Vim, Java 17 (or another JDK with `javac`), and OpenSSL.

From this directory:

```sh
./start.sh
vim task1/task1.md task1/Passenger.java task1/Bus.java
./test.sh 1
./time.sh
```

At the 60-minute mark, run `./unlock.sh`, read `task2/task2.md`, edit the Java files copied into `task2/`, and run `./test.sh 2`. The answer directories are independent; Task 2 begins with a snapshot of your Task 1 Java files. Do not run `./start.sh` until you are ready for the clock to begin.

The timer is an honor-based local lock. Its decryption key is on your computer, so it cannot stop deliberate early inspection or clock changes. Public tests check behavior but do not mark design and style. No solution is included. This repository is public; avoid pushing your completed answers if you want them private.
