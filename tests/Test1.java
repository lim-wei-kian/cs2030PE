/** Public checks for Task 1 sections 1 and 2. */
public class Test1 {
  public static void main(String[] args) {
    Checks.equal("integer operand", 5, new Operand(5).eval());
    Checks.equal("string operand", "hello", new Operand("hello").eval());
    Checks.equal("boolean operand", true, new Operand(true).eval());
    Checks.equal("exception message", "ERROR: Invalid operand for operator !",
        new InvalidOperandException('!').getMessage());
    Checks.finish();
  }
}
