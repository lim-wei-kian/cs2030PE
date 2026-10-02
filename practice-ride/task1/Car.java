/**
 * A car available for selected services.
 *
 * @author REPLACE_WITH_STUDENT_NUMBER
 */
public abstract class Car {
  // TODO: store the immutable license plate and waiting time.

  protected Car(String plate, int waitTime) {
    // TODO
  }

  public int getWaitTime() {
    return -1; // TODO
  }

  public String getPlate() {
    return "TODO";
  }

  public abstract boolean provides(Service service);

  protected abstract String typeName();

  @Override
  public String toString() {
    return "TODO";
  }
}
