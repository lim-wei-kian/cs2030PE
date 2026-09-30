/** Passenger and checked exception checks. */
public class Test1 {
  public static void main(String[] args) {
    Passenger first = new Passenger(2);
    Passenger second = new Passenger(1);
    Checks.equal("first passenger", "P0->COM2", first.toString());
    Checks.equal("second passenger", "P1->COM1", second.toString());
    Checks.equal("destination", 2, first.getDestination());
    Checks.check("destination match", first.hasReachedDestination(2));
    Checks.check("destination differs", !first.hasReachedDestination(1));
    Checks.equal("checked exception", "Testing", new CannotBoardException("Testing").getMessage());
    Checks.finish();
  }
}
