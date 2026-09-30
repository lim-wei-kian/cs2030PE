/** Basic bus state checks. */
public class Test2 {
  public static void main(String[] args) throws CannotBoardException {
    Bus bus = new Bus(2, 3);
    Checks.equal("initial bus", "B0@COM0 passengers: [ ] [ ] [ ]", bus.toString());
    Checks.check("board returns bus", bus.board(new Passenger(2)) == bus);
    Checks.equal("one aboard", "B0@COM0 passengers: [ ] [ ] [ P0->COM2 ]", bus.toString());
    bus.board(new Passenger(1));
    Checks.equal("destination queues", "B0@COM0 passengers: [ ] [ P1->COM1 ] [ P0->COM2 ]",
        bus.toString());
    Checks.check("move returns bus", bus.move() == bus);
    Checks.equal("next stop", "B0@COM1 passengers: [ ] [ P1->COM1 ] [ P0->COM2 ]",
        bus.toString());
    Checks.check("alight returns bus", bus.alight() == bus);
    Checks.equal("correct passenger alights", "B0@COM1 passengers: [ ] [ ] [ P0->COM2 ]",
        bus.toString());
    Checks.finish();
  }
}
