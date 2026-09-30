# Task 1 — Campus shuttle (10 marks, first 60 minutes)

A shuttle travels between `COM0`, `COM1`, ..., `COM(n-1)` in a loop. It starts at `COM0`. Passengers board with a destination stop; at each stop, passengers for that stop can alight. You are given a complete `Queue<T>` implementation and incomplete Java skeletons. Add files directly under `task1/` if useful.

Compile in the answer directory with `javac -Xlint:unchecked -Xlint:rawtypes *.java`. Add no `import` statements. Put your student number, not your name, in the `@author` tag of every Java file you change or create. You may use the supplied `Queue<T>` and an array of queues for the bus, but no Java collections. Do not edit `Queue.java`.

## 1. Passenger (2 marks)

`Passenger(int destination)` creates a passenger with an immutable unique id. Ids begin at 0 and rise by one for each new passenger. Implement `getDestination()`, `hasReachedDestination(int stopId)`, and `toString()`.

```text
new Passenger(2)                 -> P0->COM2
new Passenger(1)                 -> P1->COM1
```

Assume destinations are between 0 and `numStops - 1` for every bus the passenger boards.

## 2. Checked exception (1 mark)

`CannotBoardException` extends `Exception`. Its constructor accepts a `String` message; `getMessage()` returns exactly that string.

## 3. Bus (7 marks)

`Bus(int capacity, int numStops)` creates a bus at `COM0`. Buses also have unique ids starting at 0. Both constructor arguments are positive. Maintain a queue of passengers for each destination stop, preserving boarding order within each queue. The supplied `Queue<T>` prints its contents in square brackets and provides `add`, `poll`, `isEmpty`, `isFull`, and `size`.

- `board(Passenger p)` adds `p` to its destination queue and returns `this`. If total passengers on the bus equals its capacity, throw `new CannotBoardException("Bus is full")` without changing the bus.
- `move()` advances to the next stop, wrapping back to `COM0`, and returns `this`.
- `alight()` removes **all** passengers whose destination is the current stop, and returns `this`. Passengers for other stops remain aboard.
- `toString()` uses `B<id>@COM<stop> passengers: <queue0> <queue1> ...`. There is one space between queues, and no extra space at the end.

Example with fresh id counters:

```text
Bus bus = new Bus(2, 3)       -> B0@COM0 passengers: [ ] [ ] [ ]
bus.board(new Passenger(2))   -> B0@COM0 passengers: [ ] [ ] [ P0->COM2 ]
bus.board(new Passenger(1))   -> B0@COM0 passengers: [ ] [ P1->COM1 ] [ P0->COM2 ]
bus.move()                    -> B0@COM1 passengers: [ ] [ P1->COM1 ] [ P0->COM2 ]
bus.alight()                  -> B0@COM1 passengers: [ ] [ ] [ P0->COM2 ]
```

Run `./test.sh 1` from `practice-c/`. The later task extends this same bus, so keep its state and operations easy to reuse.
