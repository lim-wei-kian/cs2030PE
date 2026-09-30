#!/bin/sh
set -eu
cd "$(dirname "$0")"

if [ ! -f .pe-start ]; then
  echo "Run ./start.sh first."
  exit 1
fi

started=$(cat .pe-start)
now=$(date +%s)
elapsed=$((now - started))
if [ "$elapsed" -lt 0 ]; then
  echo "System clock is earlier than the start time."
  exit 1
fi

remaining=$((5400 - elapsed))
if [ "$remaining" -le 0 ]; then
  echo "90 minutes elapsed."
  exit 0
fi

echo "$((remaining / 60)) minutes $((remaining % 60)) seconds remaining."
if [ "$elapsed" -lt 3600 ]; then
  until_unlock=$((3600 - elapsed))
  echo "Task 2 unlocks in $((until_unlock / 60)) minutes $((until_unlock % 60)) seconds."
else
  echo "Task 2 is available: run ./unlock.sh."
fi
