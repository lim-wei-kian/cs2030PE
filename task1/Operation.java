/**
 * A binary expression.
 *
 * @author REPLACE_WITH_STUDENT_NUMBER
 */
public abstract class Operation {
  // TODO: model two private child expressions, which may be nested operations.
  // You may change this skeleton's signatures and add an expression abstraction.

  public static Operation of(char symbol, Object left, Object right) {
    return null; // TODO
  }

  public abstract Object eval();
}
