# Task 1 — Ride matching (10 marks, first 60 minutes)

A ride request specifies distance, passenger count, and request time. Services compute fares in cents; cars provide selected services. A booking combines a request, service, and compatible car. Implement the incomplete Java skeletons in this directory. You may add Java files here. Compile with `javac -Xlint:unchecked -Xlint:rawtypes *.java` and do not add imports or use Java collections. Mark each edited or new Java file with your student number in its `@author` tag.

Assume distance and passenger count are positive; waiting time is nonnegative. Times are integers in 24-hour HHMM form. Peak time is from 0600 to 0900 inclusive. All fares fit within `int`.

## 1. Request (1 mark)

`Request(int distance, int passengers, int time)` stores immutable values. Implement `getDistance()`, `getPassengers()`, and `getTime()`.

## 2. Services (4 marks)

Implement `Service` through `JustRide`, `TakeACab`, and `ShareARide`. Each has `int computeFare(Request request)` and a `toString()` returning exactly its class name.

| Service | Fare in cents |
| --- | --- |
| JustRide | `22 * distance`, plus 500 during peak time |
| TakeACab | `33 * distance + 200` |
| ShareARide | integer division of `50 * distance` by passengers, plus 500 during peak time |

Examples: for `Request(20, 3, 1000)`, the three fares are 440, 860, and 333 respectively. For `Request(10, 1, 900)`, they are 720, 530, and 1000.

## 3. Cars (2 marks)

`Car` is the common abstraction. `Cab` provides JustRide and TakeACab; `PrivateCar` provides JustRide and ShareARide. A constructor takes a license plate and minutes until available. Implement `getPlate()`, `getWaitTime()`, `provides(Service service)`, and `toString()` as needed.

The strings are `Cab SHA1234 (5 mins away)`, `Cab SHA1234 (1 min away)`, and `PrivateCar SU4032 (4 mins away)`. Use `min` only for 1; all other waiting times use `mins`.

## 4. Booking (3 marks)

`Booking(Car car, Service service, Request request)` rejects incompatible pairs by throwing `IllegalArgumentException` with the exact message `<car> does not provide the <service> service.`. For example: `Cab SHA1234 (5 mins away) does not provide the ShareARide service.`

Implement `Comparable<Booking>`. Compare the computed fares in ascending order; if equal, compare waiting times in ascending order. A tie in both may be broken arbitrarily in Task 1. Keep the design open to new service and car types.

From this directory, run `./test.sh 1` for the public Test1, Test2, and Test3 checks. The later task will extend the same service, car, and booking system.
