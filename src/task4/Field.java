package task4;

public class Field {
  Drunkard[][] figures;
  int maxX, maxY;

  public Field(int maxX, int maxY) {
    this.maxX = maxX;
    this.maxY = maxY;
    this.figures = new Drunkard[maxX][maxY];
  }

  public void put(Drunkard figure, Point at) {
    if (at.x < 0 || at.y < 0 || at.x >= maxX || at.y >= maxY) throw new IllegalArgumentException(at + " is out of field");
    figures[at.x][at.y] = figure;
    figure.setPoint(at);
  }

  public Drunkard get(Point at) {
    if (at.x < 0 || at.y < 0 || at.x >= maxX || at.y >= maxY) throw new IllegalArgumentException(at + " is out of field");
    return figures[at.x][at.y];
  }

  public boolean isEmpty(Point at) {
    return get(at) == null;
  }
}
