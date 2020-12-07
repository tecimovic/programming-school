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
  private Place thebeach = new Place("You are playing on the sand in the beach");
  private Place ocean = new Place("You went in the water");
  private Place underwater = new Place("You are underwater");
  private Place havana = new Place("You are in the huge capital of Cuba");
  private Place mexicocity = new Place("You are in The capital of Mexico, and the largest city in North America.");
  private Place guatemalacity = new Place("You are in Guatemala City, Guatemala's high altitude capital.");
  private Place panamacity = new Place("You are in one of the most important ports in the world. Panama City.");
  private Place bogota = new Place("You are in the capital of Colombia. Bogota.");
  private Place guayaquil = new Place("You are in Ecuador's largest city, and a port. Guayaquil.");
  private Place lima = new Place("You are in Peru's famous capital, Lima.");
  private Place santiago = new Place("You are in Chile's capital and largest city.");
  private Place ushuaia = new Place("You are in the city at the end of the world... It is pretty cold here... You see some nice mountains... Maybe you can explore?");
  private Place themountains = new Place("You went to explore some mountains near ushuaia... AAAAAAAAAAAAAAAAAAAA A YETIIIIIIIIII RUN AWAY... oops too late he trapped you in his lair... You can't get out.");
  private Place buenosaires = new Place("You visited the capital, and largest city of Argentina, Buenos Aires.");
  private Place montevideo = new Place("Welcome to Montevideo, The capital, largest city, and a port of Uruguay. You can visit  José Gervasio Artigas's monument.");
  private Place joségervasioartigasmonument = new Place("You went to see his monument! Hmm... You are so tempted to jump on his head... But maybe you shouldn't? You decide...");
  private Place hishead = new Place("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA THE COPS ARE CHASING YOU RUUUUUUUUUUUUN!");
  private Place leftorright = new Place("Wait... You don't know which way you came from... CHOOSE WISELY!!! QUICK!!!");
  private Place internationaljail = new Place("You landed in international jail. For the worst crimes only.");
  private Place asunción = new Place("You enter paraguay's capital, but you head out to the country for it's beautiful nature.");
  private Place santacruzdelasierra = new Place("You are in Bolivia's largest city.");
  private Place lapaz = new Place("You are in one of the highest altitude cities in the world. You should be careful here...");
  private Place cusco = new Place("You are in the city of Cusco, near machu pichu.");
  private Place warning = new Place("WARNING: TO STAY ALIVE IN THE CITY OF IQUITOS, YOU NEED A JUNGLEBOAT. IT IS THE ONLY BOAT THAT CAN TAKE YOU THERE. IF YOU DON'T HAVE A JUNGLEBOAT, THIS GAME WILL KILL YOU. HMM... I FORGET WHICH CITY IT WAS IN, THOUGH.");
  private Place iquitos = new Place("You are in the world's largest city unaccesable by road. Iquitos. You are in the middle of a jungle...");
  private Place caracas = new Place("You have visited Venezuela's capital, Caracas. You see beautiful mountains in the distance.");
  private Place newyork = new Place("You have visited the largest city in the United States, New York City");
  private Place chicago = new Place("You have visited the largest city on the Great Lakes, Chicago. You can eat Deep-dish pizza at Pizzeria Uno.");
  private Place pizzeriauno = new Place("You are at Pizzaria Uno. On the menu is Deep Dish Pizza, Coke, and the World's Most Alcoholic Drink.");
  private Place denver = new Place("You have arrived at Denver, near the Rocky Mountains.");
  private Place rockies = new Place("You are climbing the Rockies near Denver. Nothing went wrong. It was really nice.");
  private Place losangeles = new Place("You are in the second largest city in the United States, and the largest in the state of California, Los Angeles.");
  private Place sanfrancisco = new Place("You are in the city famous for the Golden Gate Bridge, Cable Cars, and much more, San Francisco. You can ride a cable car, or drive across the golden gate bridge.");
  private Place cablecar = new Place("You enjoy the cable car ride.");
  private Place goldengatebridge = new Place("You rode across the Golden Gate Bridge.");
  private Place vancouver = new Place("You are in one of Canada's most famous cities, Vancouver.");
  private Place iqaluit = new Place("You are in a city in Northern Canada's Nunavut Territory, Iqaluit. It is known for it's Inuit culture. 84% of Nunavut's population is Inuit!");
  private Place quebeccity = new Place("You are in a famous city that is good for tourists, and the province of Quebec's 2nd largest city, Quebec City.");
  private Place lagos = new Place("You are in the largest city in Africa, Lagos.");
  private Place cairo = new Place("You are in Egypt's capital and largest city, Cairo");

  // Create Creatures
  Thing cannedair = new Thing("canned air", "Made in Thneedville...");
  Thing GuayaquilJUNGLEBOAT = new Thing("Guayaquil JUNGLEBOAT", "The only boat in the game that can take you to Iquitos. LVL: 4");
  Thing worldsmostalcoholicdrink = new Thing("Worlds Most Alcoholic Drink", "A bottle with a clear drink, and a golden lable that says  W O R L D S  M O S T  A L C O H O L I C  D R I N K");
  public AroundTheWorldIn80Cities() {

    startingPlace.setPicture(getClass().getResource("washingtondc.jpg"));
    miami.setPicture(getClass().getResource("miami.jpg"));
    havana.setPicture(getClass().getResource("havana.jpg"));
    mexicocity.setPicture(getClass().getResource("mexicocity.jpg"));
    guatemalacity.setPicture(getClass().getResource("guatemalacity.jpg"));
    panamacity.setPicture(getClass().getResource("panamacity.jpg"));
    bogota.setPicture(getClass().getResource("bogota.jpg"));
    guayaquil.setPicture(getClass().getResource("guayaquil.jpg"));
    lima.setPicture(getClass().getResource("lima.jpg"));
    santiago.setPicture(getClass().getResource("santiago.jpg"));
    ushuaia.setPicture(getClass().getResource("ushuaia.jpg"));
    buenosaires.setPicture(getClass().getResource("buenosaires.jpg"));
    montevideo.setPicture(getClass().getResource("montevideo.jpg"));
    asunción.setPicture(getClass().getResource("asuncion.jpg"));
    santacruzdelasierra.setPicture(getClass().getResource("santacruzdelasierra.jpg"));
    lapaz.setPicture(getClass().getResource("lapaz.jpg"));
    iquitos.setPicture(getClass().getResource("iquitos.jpg"));
    caracas.setPicture(getClass().getResource("caracas.jpg"));
    cusco.setPicture(getClass().getResource("cusco.jpg"));
    newyork.setPicture(getClass().getResource("newyork.jpg"));
    chicago.setPicture(getClass().getResource("chicago.jpg"));
    denver.setPicture(getClass().getResource("denver.jpg"));
    losangeles.setPicture(getClass().getResource("losangeles.jpg"));
    sanfrancisco.setPicture(getClass().getResource("sanfrancisco.jpg"));
    vancouver.setPicture(getClass().getResource("vancouver.jpg"));
    iqaluit.setPicture(getClass().getResource("iqaluit.jpg"));
    quebeccity.setPicture(getClass().getResource("quebeccity.jpg"));
    
    Store storeExtension = new Store();
Thing NORTHKOREATOURISM = new Thing ("North Korea Tourism Access","Go to North Korea and leave.");
cannedair.setCost(5000);
NORTHKOREATOURISM.setCost(5000);
storeExtension.addThing(cannedair);
storeExtension.addThing(NORTHKOREATOURISM);
startingPlace.addExtension(storeExtension);

Store storeExtnsion = new Store();
Thing MiamiSpeeder = new Thing ("Miami Speeder", "A pretty good boat. LVL: 2");
storeExtnsion.addThing(MiamiSpeeder);
MiamiSpeeder.setCost(10000);
miami.addExtension(storeExtnsion);

 Thing onehundredollarbill = new Thing("100 dollar bill","OOOOOOOOOOOOOO DATS A LOOOOOOOOOOOOOOOOOT OF MONEH!");
 underwater.addThing(onehundredollarbill);

 Thing ahundreddollarbill = new Thing("100 dollar bill", "found it on top of a statue");
 hishead.addThing(ahundreddollarbill);

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
 GuayaquilJUNGLEBOAT.setCost(20000);
 storeguayaquil.addThing(GuayaquilJUNGLEBOAT);
 guayaquil.addExtension(storeguayaquil);

 Store storelima = new Store();
 Thing LimaAdventurer = new Thing("Lima Adventurer", "A cozy, little boat. LVL: 2");
 Thing Peruvianfood = new Thing ("Peruvian food", "A bunch of yummy things, but NO GUINEA PIGS.");
 LimaAdventurer.setCost(10000);
 Peruvianfood.setCost(5000);
 storelima.addThing(LimaAdventurer);
 storelima.addThing(Peruvianfood);
 lima.addExtension(storelima);

 Store storesantiago = new Store();
 Thing Snowjar = new Thing("Jar of Snow", "From the nearby mountains.");
 Snowjar.setCost(5000);
 storesantiago.addThing(Snowjar);
 santiago.addExtension(storesantiago);

 Store storeushuaia = new Store();
 Thing UshuaiaGlaciercutter = new Thing("Ushuaia Glaciercutter", "A boat used for getting though frozen water. LVL: 4");
 UshuaiaGlaciercutter.setCost(20000);
 storeushuaia.addThing(UshuaiaGlaciercutter);
 ushuaia.addExtension(storeushuaia);

 Store storebuenosaires = new Store();
 Thing argentinianfood = new Thing("Argentinian food", "Delicious food");
 Thing buenosairessprinter = new Thing("Buenos Aires Sprinter", "A very fast boat. LVL: 3");
 buenosairessprinter.setCost(15000);
 argentinianfood.setCost(5000);
 storebuenosaires.addThing(argentinianfood);
 storebuenosaires.addThing(buenosairessprinter);
 buenosaires.addExtension(storebuenosaires);

 Store storeparaguay = new Store();
 Thing ziplineset = new Thing("zipline set", "Made in Asunción");
 ziplineset.setCost(5000);
 storeparaguay.addThing(ziplineset);
 asunción.addExtension(storeparaguay);

 Store storesantacruzdelasierra = new Store();
 Thing crateofjewels = new Thing("crate of jewels", "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOH SHINY");
 crateofjewels.setCost(5000);
 storesantacruzdelasierra.addThing(crateofjewels);
 santacruzdelasierra.addExtension(storesantacruzdelasierra);

 Store storelapaz = new Store();
 Thing tiwanakuruins = new Thing("tiwanaku ruins", "ruins from an ancient city");
 tiwanakuruins.setCost(5000);
 storelapaz.addThing(tiwanakuruins);
 lapaz.addExtension(storelapaz);

 Store storecusco = new Store();
 Thing incatools = new Thing("inca tools", "can be used for many things");
 incatools.setCost(5000);
 storecusco.addThing(incatools);
 cusco.addExtension(storecusco);

 Store storeiquitos = new Store();
 Thing junglematerials = new Thing("jungle materials", "jungle wood, many other jungle materials");
 junglematerials.setCost(5000);
 storeiquitos.addThing(junglematerials);
 iquitos.addExtension(storeiquitos);

 Store storenewyork = new Store();
 Thing cheesecake = new Thing("cheesecake", "a New York style cheesecake");
 Thing newyorkoceanrunner = new Thing("New York Ocean Runner", "A extremely good boat. LVL: 3");
 cheesecake.setCost(5000);
 newyorkoceanrunner.setCost(15000);
 storenewyork.addThing(cheesecake);
 storenewyork.addThing(newyorkoceanrunner);
 newyork.addExtension(storenewyork);

 Store pizzeriaunomenu = new Store();
 Thing deepdishpizza = new Thing("Deep Dish Pizza", "Also known as Chicago Style Pizza.");
 Thing coke = new Thing("Coke", "Looks like Coke.");
 deepdishpizza.setCost(3000);
 coke.setCost(2000);
 worldsmostalcoholicdrink.setCost(3000);
 pizzeriaunomenu.addThing(deepdishpizza);
 pizzeriaunomenu.addThing(coke);
 pizzeriaunomenu.addThing(worldsmostalcoholicdrink);
 pizzeriauno.addExtension(pizzeriaunomenu);;

 Store storelosangeles = new Store();
 Thing boxofmovies = new Thing("box of movies", "A box of Hollywood movies.");
 Thing losangeleskite = new Thing("Los Angeles Kite", "The world's fastest kite for kitesurfing. LVL:2");
 boxofmovies.setCost(5000);
 losangeleskite.setCost(15000);
 storelosangeles.addThing(boxofmovies);
 storelosangeles.addThing(losangeleskite);
 losangeles.addExtension(storelosangeles);

 Store storevancouver = new Store();
 Thing vancouverfly = new Thing("Vancouver Fly", "A good boat for people who are learning to drive a boat. LVL:2");
 vancouverfly.setCost(15000);
 storevancouver.addThing(vancouverfly);
 vancouver.addExtension(storevancouver);

 Store storeiqaluit = new Store();
 Thing walrus = new Thing("walrus", "Inuits like to eat walrus. This one was freshely caught");
 Thing freshwaterfish = new Thing("freshwater fish", "Inuits eat freshwater fish often. This one is being sold at a market.");
 Thing iqaluitinuitboat = new Thing("Iqaluit Inuit Boat", "Does not go very fast, does not have a motor, but has a beautiful design, and is a great souvenir LVL: 1");
 walrus.setCost(5000);
 freshwaterfish.setCost(5000);
 iqaluitinuitboat.setCost(5000);
 storeiqaluit.addThing(walrus);
 storeiqaluit.addThing(freshwaterfish);
 storeiqaluit.addThing(iqaluitinuitboat);
 iqaluit.addExtension(storeiqaluit);

 Store storequebec = new Store();
 Thing poutine = new Thing("poutine", "Probably the most famous Canadian food.");
 Thing coureurduquébec = new Thing("Coureur du Quebec", "A cool, sparkely boat. LVL: 2");
 poutine.setCost(5000);
 coureurduquébec.setCost(15000);
 storequebec.addThing(poutine);
 storequebec.addThing(coureurduquébec);
 quebeccity.addExtension(storequebec);
 
 Store storecairo = new Store();
 Thing modelpyramid = new Thing("model pyramid", "a model of a pyramid");
 modelpyramid.setCost(5000);
 storecairo.addThing(modelpyramid);
 cairo.addExtension(storecairo);
 


//turnobjectsintomoney
onehundredollarbill.setAutoConvertible(true);
onehundredollarbill.setCost(10000);
ahundreddollarbill.setAutoConvertible(true);
ahundreddollarbill.setCost(10000);


//link places
startingPlace.addDirection("miami", miami);
miami.addDirection("washington DC", startingPlace);
miami.addDirection("the beach", thebeach);
thebeach.addDirection("back", miami);
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
lima.addDirection("santiago", santiago);
santiago.addDirection("lima", lima);
santiago.addDirection("ushuaia", ushuaia);
ushuaia.addDirection("explore the mountains", themountains);
ushuaia.addDirection("santiago", santiago);
ushuaia.addDirection("buenos aires", buenosaires);
buenosaires.addDirection("ushuaia", ushuaia);
buenosaires.addDirection("santiago", santiago);
buenosaires.addDirection("montevideo", montevideo);
montevideo.addDirection("buenos aires", buenosaires);
montevideo.addDirection("to his monument", joségervasioartigasmonument);
joségervasioartigasmonument.addDirection("jump on his head", hishead);
joségervasioartigasmonument.addDirection("back", montevideo);
hishead.addDirection("RUUUUUN", leftorright);
leftorright.addDirection("left", joségervasioartigasmonument);
leftorright.addDirection("right", internationaljail);
montevideo.addDirection("paraguay", asunción);
asunción.addDirection("montevideo", montevideo);
asunción.addDirection("santa cruz de la sierra", santacruzdelasierra);
santacruzdelasierra.addDirection("paraguay", asunción);
santacruzdelasierra.addDirection("la paz", lapaz);
lapaz.addDirection("santa cruz de la sierra", santacruzdelasierra);
lapaz.addDirection("cusco", cusco);
asunción.addDirection("cusco", cusco);
cusco.addDirection("la paz", lapaz);
cusco.addDirection("iquitos", warning);
warning.addDirection("nevermind", cusco);
warning.addDirection("go", iquitos);
cusco.addDirection("caracas", caracas);
iquitos.addDirection("caracas", caracas);
caracas.addDirection("cusco", cusco);
caracas.addDirection("iquitos", warning);
cusco.addDirection("caracas", caracas);
startingPlace.addDirection("new york city", newyork);
newyork.addDirection("washington DC", startingPlace);
newyork.addDirection("chicago", chicago);
chicago.addDirection("pizzeria uno", pizzeriauno);
chicago.addDirection("new york city", newyork);
pizzeriauno.addDirection("back", chicago);
chicago.addDirection("denver", denver);
newyork.addDirection("denver", denver);
denver.addDirection("new york city", newyork);
denver.addDirection("chicago", chicago);
denver.addDirection("explore the mountains", rockies);
rockies.addDirection("back to the city", denver);
denver.addDirection("los angeles", losangeles);
losangeles.addDirection("denver", denver);
denver.addDirection("san francisco", sanfrancisco);
losangeles.addDirection("san francisco", sanfrancisco);
sanfrancisco.addDirection("cable cars", cablecar);
cablecar.addDirection("back", sanfrancisco);
sanfrancisco.addDirection("drive across the Golden Gate Bridge", goldengatebridge);
goldengatebridge.addDirection("back", sanfrancisco);
goldengatebridge.addDirection("blow up the bridge", internationaljail);
sanfrancisco.addDirection("vancouver", vancouver);
vancouver.addDirection("san francisco", sanfrancisco);
vancouver.addDirection("iqaluit", iqaluit);
iqaluit.addDirection("vancouver", vancouver);
iqaluit.addDirection("quebec city", quebeccity);
quebeccity.addDirection("iqaluit", iqaluit);
quebeccity.addDirection("new york city", newyork);
lagos.addDirection("cairo", cairo);
cairo.addDirection("lagos", lagos);

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

  @Override
  public void thingAdded(Player player, Thing t, IOutput out) {
  }

  @Override
  public void thingRemoved(Player player, Thing t, IOutput out) {
  }

  @Override
  public void creatureAction(Player player, Creature creature, Place place, IOutput out) {
  }

  // Be CAREFUL with my computer
  @Override
  public void evaluateState(final Player player, final IOutput out) {
    if (player.isIn(lapaz) && !player.carries(cannedair)) {
      out.println("The good news: you visited and enjoyed La Paz for a little, the bad news: there was not enough oxegyn for you to survive.");
      player.die();
    }
      if (player.isIn(themountains)){
        out.println("They were beautiful mountains... AAAAAAAAAAAAAAAAAAAAAAAAAAA A YETI!!! The yeti ate you.");
        player.die();

        
    }
    if (player.isIn(iquitos) && !player.carries(GuayaquilJUNGLEBOAT)) {
      out.println("I warned you...");
      player.die();
    }
    if (player.isIn(pizzeriauno) && player.carries(worldsmostalcoholicdrink)) {
      out.println("You drank too much and died.");
      player.die();

    }
  }


  public static void main(final String[] args) {
    new GameUi(new AroundTheWorldIn80Cities()).start();
  }
}
