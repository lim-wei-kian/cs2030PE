/**
 * A cab that provides selected services.
 *
 * @author REPLACE_WITH_STUDENT_NUMBER
 */
public class Cab extends Car {
  public Cab(String plate, int waitTime) {
    super(plate, waitTime);
  }

  @Override
  public boolean provides(Service service) {
    return false; // TODO
  }

  @Override
  protected String typeName() {
    return "TODO";
  }
}
