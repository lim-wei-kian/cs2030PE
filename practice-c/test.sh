#!/bin/sh
set -eu
cd "$(dirname "$0")"

if ! command -v javac >/dev/null 2>&1; then
  echo "A JDK with javac is required. Install Java 17 and check javac -version."
  exit 1
fi

run_suite() {
  answer_dir=$1
  output_dir=.build/$answer_dir
  mkdir -p "$output_dir"
  if [ "$answer_dir" = task1 ]; then
    javac -Xlint:unchecked -Xlint:rawtypes -d "$output_dir" "$answer_dir"/*.java \
      tests/Checks.java tests/Test1.java tests/Test2.java tests/Test3.java
  else
    javac -Xlint:unchecked -Xlint:rawtypes -d "$output_dir" "$answer_dir"/*.java \
      tests/Checks.java tests/Test1.java tests/Test2.java tests/Test3.java tests/Test4.java
  fi
  java -cp "$output_dir" Test1
  java -cp "$output_dir" Test2
  java -cp "$output_dir" Test3
  if [ "$answer_dir" = task2 ]; then
    java -cp "$output_dir" Test4
  fi
}

case "${1:-}" in
  1) run_suite task1 ;;
  2)
    if [ ! -f task2/task2.md ]; then
      echo "Task 2 is locked. Run ./unlock.sh after 60 minutes."
      exit 1
    fi
    run_suite task2
    ;;
  all)
    run_suite task1
    if [ -f task2/task2.md ]; then
      run_suite task2
    else
      echo "Task 2 is still locked."
    fi
    ;;
  *) echo "Usage: ./test.sh 1|2|all"; exit 2 ;;
esac
