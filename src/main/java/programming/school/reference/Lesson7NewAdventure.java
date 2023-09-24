package programming.school.reference;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson7NewAdventure implements IAdventureGame {

    // Create places
    private final Place emptyness = new Place("You are in a void. There is nothing.");

    public Lesson7NewAdventure() {
    }

    @Override
    public String playerName() {
        return "Nowhere man.";
    }

    @Override
    public Place startingPlace() {
        return emptyness;
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
