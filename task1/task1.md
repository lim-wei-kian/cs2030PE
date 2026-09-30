# Task 1 — Expressions (10 marks, first 60 minutes)

Build a small expression system. An expression evaluates to a value. An `Operand` holds a value; a binary `Operation` evaluates its left and right expressions and combines them. The two operands of an operation can themselves be operations.

You are given incomplete `Operand.java`, `Operation.java`, and `InvalidOperandException.java`. You may add Java files directly under `task1/`. Design an abstraction common to operands and operations so nested expressions are possible. The test driver compiles with:

```sh
javac -Xlint:unchecked -Xlint:rawtypes *.java
```

Do not add `import` statements or use arrays/collections to represent expressions. Keep the two child expressions of an operation private. Every Java file you change or add must have your student number in an `@author` tag near the top.

## 1. Operand (2 marks)

`new Operand(value).eval()` returns `value`, where the value can be any reference type. For example, `new Operand(5).eval()` is `5`, and `new Operand("hi").eval()` is `"hi"`.

## 2. Invalid operand (1 mark)

`InvalidOperandException` is unchecked. Its constructor takes a `char` operator, and its message must be exactly `ERROR: Invalid operand for operator <operator>`.

## 3. Binary operations (7 marks)

`Operation.of(char operator, expression left, expression right)` returns an operation for the following symbols, or `null` for an unsupported symbol:

| Symbol | Required evaluated types | Result |
| --- | --- | --- |
| `*` | two `Integer` values | integer multiplication |
| `+` | two `String` values | concatenation |
| `^` | two `Boolean` values | boolean XOR |

The arguments can be `Operand` or nested `Operation` instances. `eval()` evaluates the left expression first, then the right, then checks the types. For an invalid type, throw `InvalidOperandException` for the *current* operator. If evaluating a child throws an exception, let that child's exception propagate unchanged. For this practice exercise, operands are non-null and the integer arithmetic examples do not overflow.

Examples:

```java
Operation.of('*', new Operand(2), new Operand(3)).eval()    // 6
Operation.of('+', new Operand("a"), new Operand("b")).eval() // "ab"
Operation.of('^', new Operand(true), new Operand(false)).eval() // true
Operation.of('!', new Operand(2), new Operand(3))           // null
```

If `inner = Operation.of('*', new Operand(2), new Operand(3))`, then `Operation.of('*', inner, new Operand(4)).eval()` returns `24`. Multiplying `new Operand("2")` by `new Operand(3)` instead throws with message `ERROR: Invalid operand for operator *`.

Run `./test.sh 1` from the repository root. Public checks are split into `Test1`, `Test2`, and `Test3`. They verify correctness but cannot award design or style marks.

The later task will change this same expression system. Keep the operator-specific behavior extensible.
