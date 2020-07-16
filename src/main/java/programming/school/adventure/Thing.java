package programming.school.adventure;

public class Thing implements IExaminable {

  private final String name, description;

  public Thing(final String name, final String description) {
    this.name = name;
    this.description = description;
  }

  public Thing(final String name) {
    this(name, null);
  }

  public String name() {
    return name;
  }

  public String description() {
    return description;
  }
}
