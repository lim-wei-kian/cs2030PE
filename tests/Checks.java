/** Public test helper; not part of your submitted answer. */
public final class Checks {
  private static int passed = 0;
  private static int total = 0;

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

  public static void invalid(String label, char symbol, Runnable action) {
    total += 1;
    try {
      action.run();
      System.out.println("FAIL " + label + ": no exception");
    } catch (InvalidOperandException e) {
      String expected = "ERROR: Invalid operand for operator " + symbol;
      if (expected.equals(e.getMessage())) {
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
