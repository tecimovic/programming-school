package programming.school.adventure;

public interface IPlaceExtension {

  public boolean runCommand(Player player, String command, String argument);
  public String description();
  public Thing findThing(String name);
}
