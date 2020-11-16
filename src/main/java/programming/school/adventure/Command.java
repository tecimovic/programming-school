package programming.school.adventure;

public enum Command implements ICommand {
  GO, 
  TAKE, 
  EXAMINE, 
  DROP, 
  DIE, 
  LOOK, 
  INVENTORY, 
  EAT,
  HELP;
  
  @Override
  public String commandName() {
    return name().toLowerCase();
  }
  
  /** Resolves a command */
  public static Command resolve(String txt) {
    for ( Command c: values() ) {
      if ( c.commandName().equals(txt.trim().toLowerCase())) return c;
    }
    return null;
  }
}
