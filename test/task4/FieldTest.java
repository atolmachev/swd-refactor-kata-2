package task4;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static task4.Point.at;

public class FieldTest {

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenPuttingObjectOnPointOutOfField() {
    Field field = new Field(10, 10);
    field.put(new Drunkard(), at(1, 12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenPuttingObjectOnPointWithNegativeCoordinate() throws Exception {
    Field field = new Field(10, 10);
    field.put(new Drunkard(), at(-1, 6));
  }

  @Test
  public void shouldReturnPutObjectOnGet() {
    Field field = new Field(10, 10);
    Drunkard figure = new Drunkard();
    field.put(figure, at(2, 5));
    assertEquals(figure, field.get(at(2, 5)));
    assertEquals(at(2, 5), figure.getPoint());
  }

  @Test
  public void shouldReturnNullIfNoObjectAtPoint() {
    Field field = new Field(10, 10);
    assertTrue(field.isEmpty(at(3, 5)));
    assertNull(field.get(at(3, 5)));
  }

  @Test(timeout = 5000)
  public void shouldBeAbleToCreateBigFields() throws Exception {
    Field field = new Field(100000, 100000);
  }

  @Test(timeout = 5000)
  public void shouldBeAbleToHandleLotsOfFigures() throws Exception {
    Field field = new Field(100000, 100000);
    Random random = new Random(this.hashCode());
    IntStream.range(0, 10000000).forEach(value -> {
      int x = random.nextInt(100000);
      int y = random.nextInt(100000);
      field.put(new Drunkard(), at(x, y));
    });
  }
}