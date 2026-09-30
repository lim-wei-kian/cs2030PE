/** Public checks for basic operations. */
public class Test2 {
  public static void main(String[] args) {
    Checks.equal("multiplication", 6,
        Operation.of('*', new Operand(2), new Operand(3)).eval());
    Checks.equal("concatenation", "helloworld",
        Operation.of('+', new Operand("hello"), new Operand("world")).eval());
    Checks.equal("xor", true,
        Operation.of('^', new Operand(true), new Operand(false)).eval());
    Checks.equal("unknown operator", null,
        Operation.of('!', new Operand(2), new Operand(3)));
    Checks.finish();
  }
}
