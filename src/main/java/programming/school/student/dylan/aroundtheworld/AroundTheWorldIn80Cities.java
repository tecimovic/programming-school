package programming.school.student.dylan.aroundtheworld;

import programming.school.adventure.Creature;
import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Place;
import programming.school.adventure.Player;
import programming.school.adventure.Store;
import programming.school.adventure.Thing;
import programming.school.adventure.ui.GameUi;

public class AroundTheWorldIn80Cities implements IAdventureGame {

  // Create places
  private Place startingPlace = new Place("You are in the capital of the United States. Washington DC.");
  private Place miami = new Place("You are in Miami. Will you go to the beach?");
  private Place thebeach = new Place("You are swimming in the beach");
  private Place ocean = new Place("You went in the water");
  private Place underwater = new Place("You are underwater");
  private Place havana = new Place("You are in the huge capital of Cuba");
  private Place mexicocity = new Place("You are in The capital of Mexico, and the largest city in North America.");
  private Place guatemalacity = new Place("You are in Guatemala City, Guatemala's high altitude capital.");
  private Place panamacity = new Place("You are in one of the most important ports in the world. Panama City.");
  private Place bogota = new Place("You are in the capital of Colombia. Bogota.");
  private Place guayaquil = new Place("You are in Ecuador's largest city, and a port. Guayaquil.");
  private Place lima = new Place("You are in Peru's famous capital, Lima.");
  // Create Creatures

  public AroundTheWorldIn80Cities() {
    Store storeExtension = new Store();
Thing NORTHKOREATOURISM = new Thing ("North Korea Tourism Access","Go to North Korea and leave.");
NORTHKOREATOURISM.setCost(5000);
storeExtension.addThing(NORTHKOREATOURISM);
startingPlace.addExtension(storeExtension);

Store storeExtnsion = new Store();
Thing MiamiSpeeder = new Thing ("Miami Speeder", "A pretty good boat. LVL: 2");
storeExtnsion.addThing(MiamiSpeeder);
MiamiSpeeder.setCost(10000);
miami.addExtension(storeExtnsion);

 Thing onehundredollarbill = new Thing("100 dollar bill","OOOOOOOOOOOOOO DATS A LOOOOOOOOOOOOOOOOOT OF MONEH!");
 underwater.addThing(onehundredollarbill);

 Store storehavana = new Store();
 Thing Cigarsandrum = new Thing("Cigars and Rum","What Cuba is known for.");
 Thing Havanawaveglider = new Thing("Havana Waveglider", "A cheap boat, a good deal. LVL: 1");
 Cigarsandrum.setCost(5000);
 Havanawaveglider.setCost(5000);
 storehavana.addThing(Cigarsandrum);
 storehavana.addThing(Havanawaveglider);
 havana.addExtension(storehavana);

 Store storemexicocity = new Store();
 Thing Mexicanfood = new Thing("Mexican food", "Tacos, and many other delicious things.");
 Mexicanfood.setCost(5000);
 storemexicocity.addThing(Mexicanfood);
 mexicocity.addExtension(storemexicocity);

 Store storeguatemalacity = new Store();
 Thing mayanartifact = new Thing("Mayan artifact", "A nice Mayan bowl filled with cocoa beans");
 mayanartifact.setCost(5000);
 storeguatemalacity.addThing(mayanartifact);
 guatemalacity.addExtension(storeguatemalacity);

 Store storepanamacity = new Store();
 Thing PanamaSupaFast = new Thing("Panama Supa Fast", "An awesome boat. LVL: 3");
 PanamaSupaFast.setCost(15000);
 storepanamacity.addThing(PanamaSupaFast);
 panamacity.addExtension(storepanamacity);

 Store storebogota = new Store();
 Thing Bogotaemerald = new Thing("Bogota Emerald", "Bogota is known for producing the world's finest emeralds.");
 Bogotaemerald.setCost(5000);
 storebogota.addThing(Bogotaemerald);
 bogota.addExtension(storebogota);

 Store storeguayaquil = new Store();
 Thing GuayaquilJUNGLEBOAT = new Thing("Guayaquil JUNGLEBOAT", "The only boat in the game that can take you to Iquitos. LVL: 4");
 storeguayaquil.addThing(GuayaquilJUNGLEBOAT);
 guayaquil.addExtension(storeguayaquil);

 Store storelima = new Store();
 Thing LimaAdventurer = new Thing("Lima Adventurer", "A cozy, little boat. LVL: 2");
 Thing Peruvianfood = new Thing ("Peruvian food", "A bunch of yummy things, but NO GUINEA PIGS.");
 storelima.addThing(LimaAdventurer);
 storelima.addThing(Peruvianfood);
 lima.addExtension(storelima);
//turnobjectsintomoney
onehundredollarbill.setAutoConvertible(true);
onehundredollarbill.setCost(10000);


//link places
startingPlace.addDirection("miami", miami);
miami.addDirection("washington DC", startingPlace);
miami.addDirection("the beach", thebeach);
thebeach.addDirection("miami", miami);
thebeach.addDirection("water", ocean);
ocean.addDirection("out of the water", thebeach);
ocean.addDirection("dive deeper", underwater);
underwater.addDirection("back up", ocean);
miami.addDirection("havana", havana);
havana.addDirection("miami", miami);
havana.addDirection("mexico city", mexicocity);
mexicocity.addDirection("havana", havana);
mexicocity.addDirection("guatemala city", guatemalacity);
guatemalacity.addDirection("mexico city", mexicocity);
guatemalacity.addDirection("panama city", panamacity);
panamacity.addDirection("guatemala city", guatemalacity);
panamacity.addDirection("bogota", bogota);
bogota.addDirection("panama city", panamacity);
bogota.addDirection("guayaquil", guayaquil);
guayaquil.addDirection("bogota", bogota);
guayaquil.addDirection("lima", lima);
lima.addDirection("guayaquil", guayaquil);
}



  @Override
  public String playerName() {
    return "Traveller";
  }

  @Override
  public Place startingPlace() {
    return startingPlace;
  }

  @Override
  public String introductionText() {
    return "You need to visit many cities without dieing.";
  }

  @Override
  public String victoryText() {
    return "Yay!";
  }

  // Saddle bonus points ++
  @Override
  public void thingAdded(Player player, Thing t, IOutput out) {
  }

  // Saddle bonus points --
  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
  }

  // Be CAREFUL with my computer
  @Override
  public void evaluateState(final Player player, final IOutput out) {
  }

  public static void main(final String[] args) {
    new GameUi(new AroundTheWorldIn80Cities()).start();
  }

}
