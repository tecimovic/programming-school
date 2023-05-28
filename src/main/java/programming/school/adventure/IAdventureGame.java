package programming.school.adventure;

import programming.school.adventure.currency.DollarCentCurrency;
import programming.school.adventure.currency.ICurrency;

public interface IAdventureGame {

  public void evaluateState(Player player, IOutput out);

  public Place startingPlace();

  public String playerName();

  public String introductionText();

  public String victoryText();

  // Various possible callbacks.
  public default boolean allowGoShortcut() {
    return false;
  }

  public default void thingAdded(Player player, Thing t, IOutput out) {

  }

  public default void thingRemoved(Player player, Thing t, IOutput out) {
  }

  public default void creatureAction(Player player,
      Creature creature,
      Place place,
      IOutput out) {
  }

  public default boolean canPlayerMove(Player player,
      Place from,
      Place to,
      IOutput out) {
    return true;
  }

  public default ICurrency currency() {
    return DollarCentCurrency.INSTANCE;
  };

  /**
   * Initialization of the player. Called right at the beginning.
   * 
   * @param player
   */
  public default void initializePlayer(Player player) {
  }

  public default String windowTitle() {
    return "Adventure game";
  }
}
