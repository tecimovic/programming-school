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
  private Place newyork = new Place("You have visited the largest city in the United States, New York City. You can eat a cheesecake, buy a boat, and go to the top of the Freedom Tower, the tallest building in the USA.");
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
  private Place lagos = new Place("You are in the largest cigty in Africa, Lagos.");
  private Place cairo = new Place("You are in Egypt's capital and largest city, Cairo");
  private Place istanbul = new Place("You are in the city in two continents (Unless Eurasia is one continent), Istanbul ");
  private Place dubrovnik = new Place("You are in Croatia's 13th largest city, although a very small city, it is also a very beautiful and old city.");
  private Place rotterdam = new Place("You are in Europe's busiest port, Rotterdam");
  private Place charleston = new Place("You are in a beautiful city, and the largest city in South Carolina. Charleston.");
  private Place jailhalls = new Place("The hallways of the jail.");
  private Place cafeteria = new Place("Where the jail serves their 'gourmet' food");
  private Place jailyard = new Place("You are in the yard of the jail. This is where you exercise.");
  //private Place celltime = new Place("Jail Guard: ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL. I repeat: ITS CELL TIME GO BACK TO YOUR CELL. Yes, I said ITS CELL TIME GO BACK TO YOUR CELL. Yup. ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL. Are you even listening? ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL. So, you're not listening? Alright, ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL. Aand... ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL. Ooh... Fun fact... The entire world's population could fit inside Los Angeles... ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL... Ooh... Another fun fact... North Korea and Cuba are the only places you can't buy Coca-Cola... ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ITS CELL TIME GO BACK TO YOUR CELL ...That's it.");
  private Place Staugustine = new Place ("Ben's Hometown and America's oldest city");
  private Place thepathway = new Place ("you dont know what you are doing");
  private Place ohgreat = new Place ("this place is still under construction");
  private Place notthere = new Place ("it Is  a GLITCH that THIS place is even accesible e!");
  private Place no = new Place ("you  w    i LL regre t THI S               !");
  private Place territoryoflostsouls = new Place ("You are in a strange room. 'Hi there' a man greets you. Then he gasps and stares in awe at your purple stick that you found in Novosibirsk. 'THE KEY!' he yells. 'HOW DID YOU FIND IT? WE HID IT IN THE FORESTS NEXT TO SOME CITY IN THE MIDDLE OF NOWHERE! welcome to the Territory of Lost Souls! You were the first ever not lost soul here, cuz you found the key.' You see a crystal on a table. 'What is that?' you ask. 'Oh.' he says. 'Thats the crystal of despair. It turns people who touch it into lost souls, but please don't take it.' You are thinking. Maybe you could pick it up using a spork? You see one lying on the floor. Or you could just leave it. ");
  private Place novosibirsk = new Place ("You are in the largest city in Siberia, Novosibirsk");
  private Place Washingtonmuseum = new Place ("You are in a museum in Washington DC.");
  private Place portofnewyork = new Place ("You are in a huge dock, and you see your boat right there. Before going to the dock, go to the Port Schedules and make sure your boat is appropriate for the route. You can also go straight to LA with the NY-LA ferry, or strait to Rio de Janerio.");
  private Place newyorkportschedules = new Place ("All it says is this: It would take a strong boat to traverse the North Atlantic, and come to Rotterdam, and a boat must be good at withstanding heat to visit Lagos.");
  private Place newyorkdock = new Place ("You are in a dock. This is your final warning to decide your route, and make sure you can accomplish the route. ");
  private Place barcelona = new Place ("You are in a beautiful, old, and 2nd largest in Spain, Barcelona.");
  private Place iqaluitbeach = new Place("You are in the Iqaluit Beach.");
  private Place iqaluitswimming = new Place("You are swimming in Iqaluit. Brr!!! It is cold!");
  private Place jailtelephoneroom = new Place("A room with telephones... but none of them work.");
  private Place portoflosangeles = new Place("You are in the port of Los Angeles. Go to the LA-NY ferry to go straight to New York City.");
  private Place northatlantic = new Place("You wish there were planes in this game. The waves are huge.");
  private Place portofrotterdam = new Place("You are in a huge port, the biggest in Europe!.");
  private Place rotterdamdock = new Place("Let me guess, you just arrived from New York.");
  private Place riodejanerio = new Place("You are in Brazil's most populous city, Rio De Janeiro.");
  private Place portofriodejanerio = new Place("This port can take you to New York.");
  private Place northatlanticthesecond = new Place("...");
  

  Thing cannedair = new Thing("canned air", "Made in Thneedville...");
  Thing GuayaquilJUNGLEBOAT = new Thing("Guayaquil JUNGLEBOAT", "The only boat in the game that can take you to Iquitos. LVL: 4");
  Thing worldsmostalcoholicdrink = new Thing("Worlds Most Alcoholic Drink", "A bottle with a clear drink, and a golden lable that says  W O R L D S  M O S T  A L C O H O L I C  D R I N K");
  Thing deadratcasserole = new Thing("Dead Rat Casserole", "Looks weird...");
  Thing apurplestick = new Thing("A purple stick", "Wow! Looks cool! Never seen anything like it. Just lying on the ground!");
  Thing MiamiSpeeder = new Thing ("Miami Speeder", "A pretty good boat. LVL: 2");
  Thing eternalheater = new Thing("Eternal Heater", "Helps you survive colder places!");
  Thing jailtelephone1 = new Thing("Broken Telephone", "you can't call anybody with it");
  Thing jailtelephone2 = new Thing("Broken Telephone", "you can't call anybody with it");
  Thing jailtelephone3 = new Thing("Broken Telephone", "you can't call anybody with it");
  Thing benedictarnoldwasatraitor = new Thing("A book titled The horrible benedict arnold", "Why not buy it?");
  Thing newyorkoceanrunner = new Thing("New York Ocean Runner", "An extremely strong boat!");

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
    charleston.setPicture(getClass().getResource("charleston.jpg"));
    
    Store storeExtension = new Store();
Thing NORTHKOREATOURISM = new Thing ("North Korea Tourism Access","Go to North Korea and leave.");
cannedair.setCost(5000);
NORTHKOREATOURISM.setCost(5000);
storeExtension.addThing(cannedair);
storeExtension.addThing(NORTHKOREATOURISM);
startingPlace.addExtension(storeExtension);

Store storeExtnsion = new Store();
storeExtnsion.addThing(MiamiSpeeder);
MiamiSpeeder.setCost(10000);
miami.addExtension(storeExtnsion);

 Thing onehundredollarbill = new Thing("100 dollar bill","OOOOOOOOOOOOOO DATS A LOOOOOOOOOOOOOOOOOT OF MONEH!");
 underwater.addThing(onehundredollarbill);

 Thing ahundreddollarbill = new Thing("100 dollar bill", "found it on top of a statue");
 hishead.addThing(ahundreddollarbill);

 Thing twohundreddollarbill = new Thing("200 dollar bill", "found while swimming in IQALUIT!");
 iqaluitswimming.addThing(twohundreddollarbill);

 cafeteria.addThing(deadratcasserole);


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
 Thing fakewalrus = new Thing("fake walrus", "Inuits liked to eat walrus. This one is not a real walrus because they are endangered");
 Thing freshwaterfish = new Thing("freshwater fish", "Inuits would eat freshwater fish often. This one is being sold at a market.");
 Thing iqaluitinuitboat = new Thing("Iqaluit Inuit Boat", "Does not go very fast, does not have a motor, but has a beautiful design, and is a great souvenir LVL: 1");
 fakewalrus.setCost(5000);
 freshwaterfish.setCost(5000);
 iqaluitinuitboat.setCost(5000);
 eternalheater.setCost(10000);
 storeiqaluit.addThing(fakewalrus);
 storeiqaluit.addThing(freshwaterfish);
 storeiqaluit.addThing(iqaluitinuitboat);
 storeiqaluit.addThing(eternalheater);
 iqaluit.addExtension(storeiqaluit);

 Store storequebec = new Store();
 Thing poutine = new Thing("poutine", "Probably the most famous Canadian food.");
 Thing coureurduquébec = new Thing("Coureur du Quebec", "A cool, sparkely boat. LVL: 2");
 benedictarnoldwasatraitor.setCost(5000);
 poutine.setCost(5000);
 coureurduquébec.setCost(15000);
 storequebec.addThing(poutine);
 storequebec.addThing(coureurduquébec);
 storequebec.addThing(benedictarnoldwasatraitor);
 quebeccity.addExtension(storequebec);
 
 Store storecairo = new Store();
 Thing modelpyramid = new Thing("model pyramid", "a model of a pyramid");
 modelpyramid.setCost(5000);
 storecairo.addThing(modelpyramid);
 cairo.addExtension(storecairo);

 Store storenovosibirsk = new Store();
 apurplestick.setCost(200000);
 storenovosibirsk.addThing(apurplestick);
 novosibirsk.addExtension(storenovosibirsk);

 


//turnobjectsintomoney
onehundredollarbill.setAutoConvertible(true);
onehundredollarbill.setCost(10000);
ahundreddollarbill.setAutoConvertible(true);
ahundreddollarbill.setCost(10000);
twohundreddollarbill.setAutoConvertible(true);
twohundreddollarbill.setCost(20000);


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
cusco.addLockedDirection("iquitos", iquitos, GuayaquilJUNGLEBOAT);
cusco.addDirection("caracas", caracas);
iquitos.addDirection("caracas", caracas);
caracas.addDirection("cusco", cusco);
caracas.addLockedDirection("iquitos", iquitos, GuayaquilJUNGLEBOAT);
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
newyork.addDirection("quebec city", quebeccity);
cairo.addDirection("istanbul", istanbul);
startingPlace.addDirection("charleston", charleston);
miami.addDirection("charleston", charleston);
charleston.addDirection("washington dc", startingPlace);
charleston.addDirection("miami", miami);
internationaljail.addDirection("out of cell", jailhalls);
jailhalls.addDirection("back to cell", internationaljail);
jailhalls.addDirection("cafeteria", cafeteria);
cafeteria.addDirection("hallways", jailhalls);
jailhalls.addDirection("yard", jailyard);
jailyard.addDirection("go back inside", jailhalls);
miami.addDirection("st. augustine", Staugustine);
charleston.addDirection("st. augustine", Staugustine);
Staugustine.addDirection("miami", miami);
Staugustine.addDirection("charleston", charleston);
chicago.addDirection("D#ONT Y#OU DAR#E", thepathway);
thepathway.addDirection("hehe hehe h e", ohgreat);
thepathway.addDirection("THIS WAY, BACK TO WHERE YOU WERE BEFORE", chicago);
ohgreat.addDirection("PLEASE GO BACK THIS WAY", chicago);
ohgreat.addDirection("STUBBORN stub#born S T U B B O R N", notthere);
notthere.addDirection("ohMY gOd y####ou ar e ST OOoPID", no);
caracas.addDirection("bogota", bogota);
no.addDirection("LAST WAAAAAR#####NINNNNGGGGG", territoryoflostsouls);
startingPlace.addDirection("Washington DC Museum", Washingtonmuseum);
Washingtonmuseum.addDirection("back", startingPlace);
newyork.addDirection("Port of New York", portofnewyork);
portofnewyork.addDirection("back", newyork);
portofnewyork.addDirection("view port schedules", newyorkportschedules);
newyorkportschedules.addDirection("back", portofnewyork);
portofnewyork.addDirection("dock", newyorkdock);
iqaluit.addDirection("iqaluit beach", iqaluitbeach);
iqaluitbeach.addDirection("back", iqaluit);
iqaluitbeach.addDirection("go swimming", iqaluitswimming);
iqaluitswimming.addDirection("back", iqaluitbeach);
Washingtonmuseum.addDirection("grab a painting or two, for the road, ya know", internationaljail);
cafeteria.addDirection("telephone room", jailtelephoneroom);
jailtelephoneroom.addDirection("cafeteria", cafeteria);
portofnewyork.addDirection("NY-LA ferry", portoflosangeles);
portoflosangeles.addDirection("back", losangeles);
portoflosangeles.addDirection("LA-NY ferry", portofnewyork);
losangeles.addDirection("Port of Los Angeles", portoflosangeles);
newyorkdock.addDirection("voyage to rotterdam", northatlantic);
newyorkdock.addDirection("cancel voyage", portofnewyork);
northatlantic.addDirection("keep going!!", rotterdamdock);
rotterdamdock.addDirection("back", portofrotterdam);
rotterdamdock.addDirection("voyage to new york", northatlanticthesecond);
portofrotterdam.addDirection("dock", rotterdamdock);
sanfrancisco.addDirection("los angeles", losangeles);
portofnewyork.addDirection("NY-RDJ ferry", portofriodejanerio);
portofriodejanerio.addDirection("RDJ-NY ferry", portofnewyork);
portofriodejanerio.addDirection("back", riodejanerio);
riodejanerio.addDirection("Port of Rio de Janerio", portofriodejanerio);
riodejanerio.addDirection("montevideo", montevideo);
montevideo.addDirection("rio de janerio", riodejanerio);

MiamiSpeeder.setProperty("LVL2BOAT", "true");
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

  // AND STOP TICKLING ME!!

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
    if (player.isIn(cafeteria) && player.carries(deadratcasserole)) {
      out.println("Err... Let's just say it was not as good as that Chicago-Style Pizza...");
      player.die();

    }

    if (player.isIn(territoryoflostsouls) && !player.carries(apurplestick)) {
        out.println("idiot");
        player.die();

    }


    if (player.isIn(iqaluitswimming)  && !player.carries(eternalheater)) {
        out.println("You froze to death");
        player.die();


    }

    if (player.carries(benedictarnoldwasatraitor)) {
      out.println("Benedict Arnold's ghost was offended and murdered you.");
      player.die();

    }

    if (player.isIn(northatlantic)  && !player.carries(newyorkoceanrunner)) {
      out.println("your boat sunk before you made it");
      player.die();
    }

    if (player.isIn(northatlanticthesecond)  && !player.carries(newyorkoceanrunner)) {
      out.println("Why did you drop the ocean runner???");
      player.die();
    }

  }


    

 


  public static void main(final String[] args) {
    new GameUi(new AroundTheWorldIn80Cities()).start();
  }
}
