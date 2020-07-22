package programming.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.PlayerState;
import programming.school.adventure.ui.GameTest;
import programming.school.reference.Lesson6Adventure;

public class AdventureTest {

  @Test
  public void testReferenceAdventureQuickDeath() {
    IAdventureGame game = new Lesson6Adventure();
    GameTest test = new GameTest(game);
    test.start();
    
    assertNotNull(test.player());
    assertEquals(PlayerState.NORMAL, test.player().state());
    assertTrue(test.player().place().description().contains("beautiful forest"));
    test.command("go south");
    assertEquals(PlayerState.DEAD, test.player().state());
  }
  
  @Test
  public void testReferenceAdventureVictory() {
    IAdventureGame game = new Lesson6Adventure();
    GameTest test = new GameTest(game);
    test.start();
    
    assertNotNull(test.player());
    assertEquals(PlayerState.NORMAL, test.player().state());
    assertTrue(test.player().place().description().contains("beautiful forest"));
    test.command("go north");
    test.command("go downstairs");
    assertFalse(test.lastOutput().contains("sword"));
    test.command("take sword");
    test.player().inventoryDescription();
    assertTrue(test.lastOutput().contains("sword"));
    test.command("go upstairs");
    test.command("go south");
    test.command("go south");
    test.command("take key");
    test.player().inventoryDescription();
    assertTrue(test.lastOutput().contains("key"));
    test.command("go out");
    test.command("go north");
    test.command("go upstairs");
    test.command("take treasure");
    assertEquals(PlayerState.WIN, test.player().state());
    
  }
}
