/** Booking comparison and validation checks. */
public class Test3 {
  public static void main(String[] args) {
    Request request = new Request(20, 3, 1000);
    Booking cheap = new Booking(new PrivateCar("P", 5), new ShareARide(), request);
    Booking regular = new Booking(new Cab("C", 3), new JustRide(), request);
    Booking regularSlow = new Booking(new Cab("D", 6), new JustRide(), request);
    Booking expensive = new Booking(new Cab("E", 1), new TakeACab(), request);
    Checks.check("lower fare first", cheap.compareTo(regular) < 0);
    Checks.check("higher fare last", expensive.compareTo(regular) > 0);
    Checks.check("tie broken by wait", regular.compareTo(regularSlow) < 0);
    Checks.check("reverse wait tie", regularSlow.compareTo(regular) > 0);
    Checks.invalid("incompatible booking",
        "Cab SHA1234 (5 mins away) does not provide the ShareARide service.",
        () -> new Booking(new Cab("SHA1234", 5), new ShareARide(), request));
    Checks.finish();
  }
}
