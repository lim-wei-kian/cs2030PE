/** Public test helper. */
public final class Checks {
  private static int passed;
  private static int total;

  private Checks() {
  }

  public interface BoardingAttempt {
    void run() throws CannotBoardException;
  }

  public static void equal(String label, Object expected, Object actual) {
    total += 1;
    if (expected == null ? actual == null : expected.equals(actual)) {
      passed += 1;
      System.out.println("PASS " + label);
    } else {
      System.out.println("FAIL " + label + ": expected " + expected + ", got " + actual);
    }
  }

  public static void check(String label, boolean value) {
    equal(label, true, value);
  }

  public static void full(String label, BoardingAttempt attempt) {
    total += 1;
    try {
      attempt.run();
      System.out.println("FAIL " + label + ": no exception");
    } catch (CannotBoardException e) {
      if ("Bus is full".equals(e.getMessage())) {
        passed += 1;
        System.out.println("PASS " + label);
      } else {
        System.out.println("FAIL " + label + ": " + e.getMessage());
      }
    }
  }

  public static void finish() {
    System.out.println(passed + "/" + total + " public checks passed");
    if (passed != total) {
      System.exit(1);
    }
  }
}
