# CS2030S-style Expression practice PE

An original, self-contained practice exercise inspired by the structure of the attached PE paper. It is not an official NUS assessment or a copy of its question. Work locally in Terminal and Vim; no IDE or internet is needed once cloned.

**Duration:** 90 minutes. **Marks:** Task 1, 10; Task 2, 5. Task 2 becomes available 60 minutes after you start, leaving 30 minutes to extend your Task 1 design.

## Before the clock

Install a JDK with `javac` (Java 17 is recommended) and OpenSSL. On macOS, check `javac -version` and `openssl version`. The shell scripts use standard macOS tools. Set a student number in the `@author` tag of every Java file you edit; do not use your name.

Clone this repo and run from its root:

```sh
./start.sh
vim task1/Operand.java task1/Operation.java task1/InvalidOperandException.java
./test.sh 1
./time.sh
```

Read `task1/task1.md` after starting. You can edit any `.java` file directly under `task1/` and add Java files there. Compile exactly as the paper requests with `cd task1 && javac -Xlint:unchecked -Xlint:rawtypes *.java`. The test script compiles into `.build/` to avoid leaving classes in your answer directory.

At or after the 60-minute mark, run `./unlock.sh`. It copies your current Task 1 Java files into `task2/` and reveals `task2/task2.md`. Continue in `task2/`; changes there should preserve all Task 1 behavior. Run `./test.sh 2` and, before time is up, `./test.sh all`.

The supplied `task2.secret` is an honor-based local time lock. Its decryption material is necessarily on your computer, so it does not prevent a determined person from reading ahead or changing the system clock. For a realistic attempt, do not inspect the lock files or read Task 2 before `unlock.sh` permits it.

## Files

- `task1/`: question and incomplete Java skeletons; your 10-mark answer.
- `task2.secret`: sealed 5-mark extension and its public test; opened by `unlock.sh`.
- `tests/`: public Task 1 checks. These do not cover every edge case or grade design/style.
- `start.sh`, `time.sh`, `unlock.sh`, `test.sh`: local PE workflow.

There are no solutions or hidden grading tests in the repository. The local tests are practice feedback, not an official marking scheme. Do not publish your solution in a public repo if your course rules prohibit sharing it.
