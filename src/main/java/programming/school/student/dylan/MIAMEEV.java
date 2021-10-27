package programming.school.student.dylan;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.Store;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class MIAMEEV implements IAdventureGame {

    //Create Places

    private final Place starting_place = new Place ("Please choose your gamemode.");

    @Override
    public String introductionText() {
        return "Welcome to Mantette Is Already Married Extremely Early Version. (MIAMEEV)";
    }

    @Override
    public void evaluateState(Player player, IOutput out) {
        // TODO Auto-generated method stub

    }

    @Override
    public String playerName() {
        // TODO Auto-generated method stub
        return "Sea Creature";
    }

    @Override
    public Place startingPlace() {
        // TODO Auto-generated method stub
        return starting_place;
    }

    @Override
    public String victoryText() {
        // TODO Auto-generated method stub
        return "Sea Creature";
    }

    public static void main(final String[] args) {
        new GameUi(new MIAMEEV()).start();
      }
    
}