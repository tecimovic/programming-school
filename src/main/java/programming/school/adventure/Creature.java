package programming.school.adventure;

public class Creature implements IExaminable {

  private String name, description;
  private Place place = null;
  
  public Creature(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String name() {
    return name;
  }

  public String description() {
    return description;
  }
  
  public void setPlace(Place place) {
    this.place = place;
  }
  
  public Place place() {
    return place;
  }
}
