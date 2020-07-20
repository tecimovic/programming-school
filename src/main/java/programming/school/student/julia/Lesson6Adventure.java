package programming.school.student.julia;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class Lesson6Adventure implements IAdventureGame {

  // Create places
  private final Place forest = new Place("You are in a beautiful forest. There are trees all around.");
  private final Place castle = new Place(
      "You are inside the walls of a medieval castle. It has a lot of tall towers and is very beautiful.");
  private final Place armory = new
      Place("Armory is where the weapons are. There is all kind of weapons here.");
  private final Place forehead = new Place(
      "daddys forhead is shining with treasures. There are treasures of all the 5 senses in here.");
  private final Place nostril = new Place(
      "You are in a dark dangerous nostril. There is something dangerous lurking in the corner.there is also a sleeping booger.");
  private final Place eyeball = new Place("you are walking through daddys eyeball. eww.");
  private final Place wishing_well = new Place("the wishing well is full of coins. maybe you can drop one in");

  // Create things
  private final Thing sword = new Thing("sword");
  private final Thing key = new Thing("key");
  private final Thing treasure = new Thing("treasure");
  private final Thing eyelash = new Thing("eyelash");
  private final Thing coin = new Thing("coin");
  private final Thing doorhandle = new Thing("doorhandle");

  //create creatures
  private final Creature baby_booger = new Creature("baby booger", "the booger in the cave had a baby and he walks around and kills");
  public Lesson6Adventure() {

    // put pictures
    forest.setPicture(getClass().getResource("forest.jpg"));
    nostril.setPicture(getClass().getResource("cave.jpg"));
    eyeball.setPicture(getClass().getResource("daddyseyeball.jpg"));
    castle.setPicture(getClass().getResource("castle.jpg"));
    forehead.setPicture(getClass().getResource("treasure.jpg"));
    armory.setPicture(getClass().getResource("armory.jpg"));
    wishing_well.setPicture(getClass().getResource("wishingwell.jpg"));
    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", nostril);
    forest.addDirection("east", eyeball);
    forest.addDirection("west", wishing_well);

    nostril.addDirection("out", forest);

    castle.addDirection("south", forest);
    castle.addDirection("upstairs", forehead);
    castle.addDirection("downstairs", armory);

    forehead.addDirection("downstairs", castle);

    armory.addDirection("upstairs", castle);

    eyeball.addDirection("west", forest);

    wishing_well.addDirection("east", forest);

    // Add objects
    armory.addThing(sword);
    nostril.addThing(key);
    forehead.addThing(treasure);
    eyeball.addThing(eyelash);
    forest.addThing(coin);
    wishing_well.addThing(doorhandle);

    //add creatures
    nostril.addCreature(baby_booger);

  }

  @Override
  public String playerName() {
    return "knight spitball";
  }

  @Override
  public Place startingPlace() {
    return forest;
  }

  @Override
  public String introductionText() {
    return "You need to retrieve the treasure to win this game.";
  }

  @Override
  public String victoryText() {
    return "You got the treasure! You live happily ever after!";
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
    if ( creature == baby_booger ) {
      place.moveCreatureRandomly(creature);}
  }

  @Override
  public void evaluateState(final Player player, final IOutput out) {
    if (player.carries(treasure) && !player.carries(key)) {
      out.println("You don't have the key to open the treasure!");
      player.drop(treasure);
    } else if (player.carries(treasure) && player.carries(key)) {
      if (player.hasAttribute("lucky")) {
      if (player.carries(eyelash)) {
        out.println("You got the treasure!!!");
        player.setState(PlayerState.WIN);
      } else {

        out.println("the treasure turns into an eyeball and you die");
        player.setState(PlayerState.DEAD);
      }
      } else {
        out.println("the treasure turns into an eye booger and eats you");
        player.setState(PlayerState.DEAD);
      }
    } else if (player.place().hasCreature(baby_booger) && !player.carries(sword)) {
      out.println("You got attacked by a baby booger. You have no weapons. baby booger eats you....");
      player.setState(PlayerState.DEAD);
    } else if (player.place().hasCreature(baby_booger) && player.carries(sword)) {
      out.println("You got attacked by a baby booger, but you have a sword, so you fight it off.");
      
    }
  }
@Override
public boolean canPlayerMove(Player player, Place from, Place to, IOutput out) {
  if (from==forest&&to==castle) {
    if(player.carries(doorhandle)) {
      out.println("the door has no doorhandle but you have a doorhandle so you put it on");
      return true;
    } else {
      out.println("oh no! the castle door has no doorhandle!you need to find one now.");
      return false;
    }
  }
  return true;
}
  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
    if (t == coin && player.isIn(wishing_well)){
      player.setAttribute("lucky");
    }
  }

  public static void main(final String[] args) {
    new GameUi(new Lesson6Adventure()).start();
  }

}