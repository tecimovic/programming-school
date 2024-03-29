package programming.school.student.timotej;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson9Mantette implements IAdventureGame {

    private Place hole = new Place("Dark wompy hole.");
    private Place ogreLand = new Place("A smelly pit of nonsense where ogre lives!");
    private Place spinnerLand = new Place("Kaching, looks like Las Vegas in here! Wowzeee!!!!");
    private Place goblinLand = new Place("Horror show of smellyness and evilness.");

    private Creature ogre = new Creature("Ogre",
            "Smelly, wompy, horrible, insane, dangerous ogre. You hate him. And he hates you.");
    private Creature goblin = new Creature("goblin", "The most horrible, mean, evil goblin one can find.");

    public Lesson9Mantette() {
        hole.addDirection("Blue Door", ogreLand);
        hole.addDirection("Red Door", spinnerLand);
        hole.addDirection("Green Door", goblinLand);

        ogreLand.addCreature(ogre);
        goblinLand.addCreature(goblin);
    }

    @Override
    public String introductionText() {
        return "Wuga wuga, you are in a horrible land of ogres and goblins. Sometimes you can even spin a spinner for luck. Try to live to tell the tale!";
    }

    @Override
    public String playerName() {
        return "Poldi";
    }

    @Override
    public String victoryText() {
        return "Yay.....zzzzzz.....";
    }

    @Override
    public Place startingPlace() {
        return hole;
    }

    @Override
    public void evaluateState(Player player, IOutput out) {
        if (player.place() == goblinLand) {
            player.die();
        }
    }

    @Override
    public boolean allowGoShortcut() {
        return true;
    }

    public static void main(String[] args) {
        new GameUi(new Lesson9Mantette()).start();
    }
}
