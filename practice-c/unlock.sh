#!/bin/sh
set -eu
cd "$(dirname "$0")"

if [ ! -f .pe-start ]; then
  echo "Run ./start.sh first."
  exit 1
fi
if [ -e task2/task2.md ]; then
  echo "Task 2 is already unlocked."
  exit 0
fi

started=$(cat .pe-start)
now=$(date +%s)
elapsed=$((now - started))
if [ "$elapsed" -lt 3600 ]; then
  echo "Task 2 is locked for another $((3600 - elapsed)) seconds."
  exit 1
fi

if ! command -v openssl >/dev/null 2>&1; then
  echo "OpenSSL is required to unlock Task 2."
  exit 1
fi

# This key is local to the practice bundle; the timer is an honor-based lock.
key=7f4e26c9a113d0b52a8663e47c91f20bd518e0a9c662df3878a2e3540916baf
mkdir -p .pe-unlocked
if ! openssl enc -d -aes-256-cbc -pbkdf2 -in task2.secret -pass "pass:$key" | tar -xf - -C .pe-unlocked; then
  echo "Could not open task2.secret. Your Task 1 work is unchanged."
  exit 1
fi

mkdir -p task2
cp task1/*.java task2/
mv .pe-unlocked/task2.md task2/task2.md
mv .pe-unlocked/Test4.java tests/Test4.java
echo "Task 2 unlocked. Your current Task 1 Java files were copied into task2/."
echo "Read task2/task2.md and edit task2/; run ./test.sh 2."
