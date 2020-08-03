// Copyright (c) 2020 Silicon Labs. All rights reserved.

package programming.school.adventure;

public interface IAdventureGame {
  
  public void evaluateState(Player player, IOutput out);
  public Place startingPlace();
  public String playerName();
  public String introductionText();
  public String victoryText();
  // Various possible callbacks.
  public default void thingAdded(Player player, Thing t, IOutput out) {}
  public default void thingRemoved(Player player, Thing t, IOutput out) {}
  public default void creatureAction(Player player, Creature creature, Place place, IOutput out) {}
  public default boolean canPlayerMove(Player player, Place from, Place to, IOutput out) {return true;}
  public default String currencyDescription(int value) {
    StringBuilder ret = new StringBuilder();
    if ( value == 0 ) 
      return "no money";
    int dollars =  value/100;
    int cents = value%100;
    if ( dollars > 0 )
      ret.append(dollars).append(" dollar");
    if ( dollars > 1 ) 
      ret.append("s");
    if ( dollars > 0 && cents > 0 ) 
      ret.append(" and ");
    if ( cents > 0 ) 
      ret.append(cents).append(" cent");
    if ( cents > 1 ) 
      ret.append("s");
    return ret.toString();
  }
  /**
   * Initialization of the player. Called right at the beginning.
   * @param player
   */
  public default void initializePlayer(Player player) {}
}

