/** Request and fare checks. */
public class Test1 {
  public static void main(String[] args) {
    Request request = new Request(20, 3, 1000);
    Checks.equal("distance", 20, request.getDistance());
    Checks.equal("passengers", 3, request.getPassengers());
    Checks.equal("time", 1000, request.getTime());
    Checks.equal("JustRide fare", 440, new JustRide().computeFare(request));
    Checks.equal("TakeACab fare", 860, new TakeACab().computeFare(request));
    Checks.equal("ShareARide rounding", 333, new ShareARide().computeFare(request));
    Checks.equal("peak begins", 522, new JustRide().computeFare(new Request(1, 1, 600)));
    Checks.equal("peak ends", 1000, new ShareARide().computeFare(new Request(10, 1, 900)));
    Checks.equal("after peak", 22, new JustRide().computeFare(new Request(1, 1, 901)));
    Checks.equal("no cab peak", 530, new TakeACab().computeFare(new Request(10, 1, 900)));
    Checks.equal("service name", "ShareARide", new ShareARide().toString());
    Checks.finish();
  }
}
