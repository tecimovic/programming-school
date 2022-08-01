package programming.school.student.julia;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.Store;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;
import programming.school.reference.Lesson7NewAdventure;

public class Lesson9MarryMantetteHaHa implements IAdventureGame {

  private final Place eeEEeeDArKPlEice = new Place("U r A duMmY cOZ U felL D0wN a h0le anD uR In a rOOm n0w");
  private final Place blue_door = new Place("oooo scary dark room (you hear groaning...)");
  private final Place its_another_blue_door = new Place("oooo bright LED-covered room (seems like a game show)");
private final Place yet_another_blue_door = new Place("there is a dragon here.(he is of course friendly because all of them are)");
private final Place oh_wow_another_blue_door = new Place("there is a pit full of amyah's bracelets. you got impaled. oof.");

private final Creature ogre = new Creature("Ogre" , "Rar");
private final Creature dragon = new Creature ("good dragon", "he's hoping you will accept his gift");



  private final Thing mr_dust_bunny = new Thing("mr_dust_bunny");

  public Lesson9MarryMantetteHaHa() {

eeEEeeDArKPlEice.addThing(mr_dust_bunny);

blue_door.addCreature(ogre);
yet_another_blue_door.addCreature(dragon);

eeEEeeDArKPlEice.addDirection ("blue door", blue_door);
eeEEeeDArKPlEice.addDirection ("its another blue door!", its_another_blue_door);
eeEEeeDArKPlEice.addDirection ("yet another blue door", yet_another_blue_door);
eeEEeeDArKPlEice.addDirection ("oh wow another blue door", oh_wow_another_blue_door);
  }
  
  @Override
  public String playerName() {
    return "snas";
  }

  @Override
  public Place startingPlace() {
    return eeEEeeDArKPlEice;
  }

  @Override
  public String introductionText() {
    return "snas want 2 merry menteette";
  }

  @Override
  public String victoryText() {
    return "keesy keesy";
  }

  public static void main(final String[] args) {
    new GameUi(new Lesson9MarryMantetteHaHa()).start();
  }

  

  public void evaluateState(final Player player, final IOutput out) {
    if (player.place() == oh_wow_another_blue_door) {
      player.die();
    }
  }
}



