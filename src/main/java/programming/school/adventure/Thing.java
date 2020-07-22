package programming.school.adventure;

public class Thing implements IExaminable {

  private final String name, description;
  private int cost = 0;
  private boolean autoConvertible = false; // If this is true,  then picking this object results in increasing money.
  
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

  public void setCost(int value) {
    this.cost = value;
  }

  public int cost() {
    return cost;
  }
  
  public void setAutoConvertible(boolean flag) {
    this.autoConvertible = flag;
  }
  
  public boolean isAutoConvertible() { 
    return autoConvertible;
  }
}
