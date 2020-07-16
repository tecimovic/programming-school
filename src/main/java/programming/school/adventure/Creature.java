package programming.school.adventure;

public class Creature implements IExaminable {

  private String name, description;

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
}
