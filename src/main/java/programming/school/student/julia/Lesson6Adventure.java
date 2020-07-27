package programming.school.student.julia;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.PlayerState;
import programming.school.adventure.Store;
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
  private final Place nothingness_hole = new Place("you are in a white cube ant there is a never ending hole");
  private final Place store = new Place("You are in a store. You can buy and sell stuff here.");
  
  
  // Create things
  private final Thing sword = new Thing("sword");
  private final Thing key = new Thing("key");
  private final Thing treasure = new Thing("treasure");
  private final Thing eyelash = new Thing("eyelash");
  private final Thing coin = new Thing("coin");
  private final Thing doorhandle = new Thing("doorhandle");
  private final Thing ten_dollar_bill = new Thing("ten dollar bill");

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

    //put sounds
    forest.setSound(getClass().getResource("birds.wav"));

    Store storeExtension = new Store();
    Thing ring = new Thing("ring", "Beautiful ring with large blueish gem.");
    ring.setCost(134);
    Thing painting = new Thing("painting", "Beautiful painting with large blueish dots.");
    painting.setCost(222);
    storeExtension.addThing(ring);
    storeExtension.addThing(painting);
    Thing scab_collection = new Thing("scab collection", "Beautiful scab collection with large jeweled frame.");
    scab_collection.setCost(344);
    Thing yugoslavia_stamp = new Thing("yugoslavia_stamp", "Beautiful stamp with a yugoslavia flag.");
    yugoslavia_stamp.setCost(999);
    storeExtension.addThing(scab_collection);
    storeExtension.addThing(yugoslavia_stamp);
    Thing stuffed_frog = new Thing("stuffed_frog", "Beautiful stamp with a yugoslavia flag.");
    stuffed_frog.setCost(3678);
    storeExtension.addThing(stuffed_frog);



    // Add place extensions
    store.addExtension(storeExtension);

    // Link places
    forest.addDirection("north", castle);
    forest.addDirection("south", nostril);
    forest.addDirection("east", eyeball);
    forest.addDirection("west", wishing_well);
    forest.addDirection("to store", store);

    nostril.addDirection("out", forest);

    castle.addDirection("south", forest);
    castle.addDirection("upstairs", forehead);
    castle.addDirection("downstairs", armory);

    forehead.addDirection("downstairs", castle);

    armory.addDirection("upstairs", castle);

    eyeball.addDirection("west", forest);

    wishing_well.addDirection("east", forest);

    eyeball.addDirection("east", nothingness_hole);

    // Add objects
    armory.addThing(sword);
    nostril.addThing(key);
    forehead.addThing(treasure);
    eyeball.addThing(eyelash);
    forest.addThing(coin);
    wishing_well.addThing(doorhandle);
    forest.addThing(ten_dollar_bill);



     // Configure objects
     ten_dollar_bill.setAutoConvertible(true);
     ten_dollar_bill.setCost(1000);

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
