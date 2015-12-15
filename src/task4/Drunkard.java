package task4;

public class Drunkard {
  boolean isSleeping = false;
  Point currentPoint;

  public void sleep() {
    isSleeping = true;
  }

  public char getAvatar() {
    return isSleeping ? '_' : '&';
  }

  public void setPoint(Point p) {
    currentPoint = p;
  }

  public Point getPoint() {
    return currentPoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Drunkard)) return false;

    Drunkard drunkard = (Drunkard) o;

    if (isSleeping != drunkard.isSleeping) return false;
    if (currentPoint != null ? !currentPoint.equals(drunkard.currentPoint) : drunkard.currentPoint != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = (isSleeping ? 1 : 0);
    result = 31 * result + (currentPoint != null ? currentPoint.hashCode() : 0);
    return result;
  }
}
