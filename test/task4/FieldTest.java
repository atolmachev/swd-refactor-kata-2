package task4;

import org.junit.Test;

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
    assertSame(figure, field.get(at(2, 5)));
    assertEquals(at(2, 5), figure.getPoint());
  }

  @Test
  public void shouldReturnNullIfNoObjectAtPoint() {
    Field field = new Field(10, 10);
    assertTrue(field.isEmpty(at(3, 5)));
    assertNull(field.get(at(3, 5)));
  }
}