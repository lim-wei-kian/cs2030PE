#!/bin/sh
set -eu
cd "$(dirname "$0")"

if [ -e .pe-start ]; then
  echo "Attempt already started. Run ./time.sh to see the remaining time."
  exit 1
fi

date +%s > .pe-start
echo "90-minute attempt started. Work on task1/task1.md now."
echo "Task 2 unlocks 60 minutes after this start time."
