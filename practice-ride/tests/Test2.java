/** Car formatting and service compatibility checks. */
public class Test2 {
  public static void main(String[] args) {
    Car cab = new Cab("SHA1234", 5);
    Car privateCar = new PrivateCar("SU4032", 1);
    Checks.equal("cab plate", "SHA1234", cab.getPlate());
    Checks.equal("cab wait", 5, cab.getWaitTime());
    Checks.equal("cab string", "Cab SHA1234 (5 mins away)", cab.toString());
    Checks.equal("private car singular", "PrivateCar SU4032 (1 min away)",
        privateCar.toString());
    Checks.check("cab JustRide", cab.provides(new JustRide()));
    Checks.check("cab TakeACab", cab.provides(new TakeACab()));
    Checks.check("cab rejects ShareARide", !cab.provides(new ShareARide()));
    Checks.check("private car ShareARide", privateCar.provides(new ShareARide()));
    Checks.check("private car rejects TakeACab", !privateCar.provides(new TakeACab()));
    Checks.finish();
  }
}
