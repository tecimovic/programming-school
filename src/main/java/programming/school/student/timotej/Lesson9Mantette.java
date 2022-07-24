package programming.school.student.timotej;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.ui.GameUi;

public class Lesson9Mantette implements IAdventureGame {

    private Place hole = new Place("A hole.");

    @Override
    public String introductionText() {
        return "Wuga wuga.";
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
    }

    @Override
    public boolean allowGoShortcut() {
        return true;
    }

    public static void main(String[] args) {
        new GameUi(new Lesson9Mantette()).start();
    }
}
