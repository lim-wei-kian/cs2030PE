/** Public checks for nested expressions and exception propagation. */
public class Test3 {
  public static void main(String[] args) {
    Operation inner = Operation.of('*', new Operand(2), new Operand(3));
    Checks.equal("nested multiplication", 24,
        Operation.of('*', inner, new Operand(4)).eval());
    Checks.invalid("invalid multiplication", '*', () ->
        Operation.of('*', new Operand("2"), new Operand(3)).eval());
    Checks.invalid("invalid concatenation", '+', () ->
        Operation.of('+', new Operand(2), new Operand("x")).eval());
    Checks.invalid("child error propagates", '*', () ->
        Operation.of('+', Operation.of('*', new Operand(2), new Operand("3")),
            new Operand("x")).eval());
    Checks.finish();
  }
}
