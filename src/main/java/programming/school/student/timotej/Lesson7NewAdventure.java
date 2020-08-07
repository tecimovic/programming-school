package programming.school.student.timotej;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {

  // basement level
  private final Place basement = new Place("You are in a basement. Lots of dady longlegses everywhere.");
  private final Place poolroom = new Place("You are in a pool room.");
  private final Place backyard = new Place("You're in a backyard.");
  private final Place frontyard = new Place("You are in a frontyard.");
  private final Place chickenland = new Place("You are next to the chicken coops.");
  
  // 1st floor
  private final Place kitchen = new Place("You are in a kitchen. There is a lot of yummy stuff there.");
  private final Place livingRoom = new Place("You are in a living room.");
  private final Place deck = new Place("You are outside on a deck.");
  private final Place littleHallway = new Place("You are in a little halway on the first floor.");
  private final Place littleBathroom = new Place("You are in a little bathroom on the first floor.");
  private final Place playroom = new Place("You are in a playroom. It's very messy.");
  private final Place office = new Place("You are in the office. Daddy is sitting at his desk and growling.");
  
  // 2nd floor
  private final Place upstairsHallway = new Place("You are upstairs.");
  private final Place oldbathroom = new Place("You are in the old bathroom.");
  private final Place bigBedroom = new Place("You are in the big bedroom.");
  private final Place bigBathroom = new Place("You are in a big bathroom.");
  private final Place dylansRoom = new Place("You are in Dylan's room.");
  private final Place juliasRoom = new Place("You are in Julia's room.");
  private final Place guestbedroom = new Place("You are in a guest bedroom.");
  private final Place attic = new Place("You are in the attic.");
  private final Place upstairsDeck = new Place("Upper deck.");
  
  public Lesson7NewAdventure() {
    attic.addDirection("down", guestbedroom);
    
    guestbedroom.addDirection("up",  attic);
    guestbedroom.addDirection("out", upstairsHallway);
    
    upstairsHallway.addDirection("bathroom", oldbathroom);
    upstairsHallway.addDirection("down", playroom);
    upstairsHallway.addDirection("dylan", dylansRoom);
    upstairsHallway.addDirection("julia", juliasRoom);
    upstairsHallway.addDirection("bedroom", bigBedroom);
    
    oldbathroom.addDirection("out", upstairsHallway);
    
    juliasRoom.addDirection("out", upstairsHallway);
    dylansRoom.addDirection("out", upstairsHallway);
    
    bigBedroom.addDirection("deck", upstairsDeck);
    bigBedroom.addDirection("bathroom", bigBathroom);
    bigBedroom.addDirection("out", upstairsHallway);
    
    upstairsHallway.addDirection("inside", bigBedroom);
    
    bigBathroom.addDirection("out", bigBedroom);
    
    playroom.addDirection("up", upstairsHallway);
    playroom.addDirection("office", office);
    playroom.addDirection("hallway", littleHallway);
    playroom.addDirection("kitchen", kitchen);
    playroom.addDirection("outside", frontyard);
    
    frontyard.addDirection("backyard", backyard);
    frontyard.addDirection("chicken", chickenland);
    
    chickenland.addDirection("front", frontyard);
    chickenland.addDirection("back", backyard);
    
    backyard.addDirection("chicken", chickenland);
    backyard.addDirection("front", frontyard);
    
    backyard.addDirection("basement", basement);
    backyard.addDirection("pool", poolroom);
    backyard.addDirection("upstairs", deck);
    
    deck.addDirection("downstairs", backyard);
    deck.addDirection("office", office);
    deck.addDirection("inside", livingRoom);
    
    livingRoom.addDirection("outside", deck);
    livingRoom.addDirection("kitchen", kitchen);
    livingRoom.addDirection("hallway", littleHallway);
    
    littleHallway.addDirection("bathroom", littleBathroom);
    littleHallway.addDirection("playroom", playroom);
    littleHallway.addDirection("living room", livingRoom);
    littleHallway.addDirection("downstairs", basement);
    
    office.addDirection("out", deck);
    office.addDirection("playroom", playroom);
    
    basement.addDirection("upstairs", littleHallway);
    basement.addDirection("pool", poolroom);
    basement.addDirection("out", backyard);
    
    poolroom.addDirection("outside", backyard);
    poolroom.addDirection("basement", basement);
    
    kitchen.addDirection("playroom", playroom);
    kitchen.addDirection("living room", livingRoom);
  }

  @Override
  public String playerName() {
    return "Nowhere man.";
  }

  @Override
  public Place startingPlace() {
    return kitchen;
  }

  @Override
  public String introductionText() {
    return "You need find purpose and meaning.";
  }

  @Override
  public String victoryText() {
    return "You are happy!";
  }


  @Override
  public void evaluateState(final Player player, final IOutput out) {
  }

  public static void main(final String[] args) {
    new GameUi(new Lesson7NewAdventure()).start();
  }

}
