package programming.school.adventure;

public enum Command {
  GO, 
  TAKE, 
  EXAMINE, 
  DROP, 
  DIE, 
  LOOK, 
  INVENTORY, 
  EAT,
  HELP;
  
  /** Resolves a command */
  public static Command resolve(String txt) {
    for ( Command c: values() ) {
      if ( c.name().toLowerCase().equals(txt.trim().toLowerCase())) return c;
    }
    return null;
  }
}
