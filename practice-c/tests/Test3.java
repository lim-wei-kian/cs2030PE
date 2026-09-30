/** Capacity, FIFO, and looping checks. */
public class Test3 {
  public static void main(String[] args) throws CannotBoardException {
    Bus bus = new Bus(2, 2);
    bus.board(new Passenger(1));
    bus.board(new Passenger(1));
    Checks.equal("FIFO queue", "B0@COM0 passengers: [ ] [ P0->COM1 P1->COM1 ]",
        bus.toString());
    Checks.full("capacity", () -> bus.board(new Passenger(0)));
    Checks.equal("failed board leaves bus intact", "B0@COM0 passengers: [ ] [ P0->COM1 P1->COM1 ]",
        bus.toString());
    bus.move().alight();
    Checks.equal("all alight", "B0@COM1 passengers: [ ] [ ]", bus.toString());
    bus.move();
    Checks.equal("wrap to COM0", "B0@COM0 passengers: [ ] [ ]", bus.toString());
    Checks.finish();
  }
}
