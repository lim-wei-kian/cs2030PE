/** Public test helper; not part of the answer. */
public final class Checks {
  private static int passed;
  private static int total;

  private Checks() {
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

  public static void check(String label, boolean actual) {
    equal(label, true, actual);
  }

  public static void invalid(String label, String message, Runnable action) {
    total += 1;
    try {
      action.run();
      System.out.println("FAIL " + label + ": no exception");
    } catch (IllegalArgumentException e) {
      if (message.equals(e.getMessage())) {
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
