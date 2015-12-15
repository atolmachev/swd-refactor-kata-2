package task4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrunkardTest {
  @Test
  public void shouldChangeAvatarAfterFellAsleep() throws Exception {
    Drunkard drunkard = new Drunkard();
    assertEquals('&', drunkard.getAvatar());

    drunkard.sleep();
    assertEquals('_', drunkard.getAvatar());
  }
}
