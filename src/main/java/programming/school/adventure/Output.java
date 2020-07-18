package programming.school.adventure;

import java.io.PrintStream;

public class Output {
  private PrintStream out;
  
  Output(PrintStream out) {
    this.out = out;
  }
  
  public void println(String message) {
    out.println(message);
  }
  
  public void println() {
    out.println();
  }
  
  public void prompt() {
    out.print("\nWhat would you  like to do?\n>");
  }
  
  public void separate() {
    out.println("\n-----------------------------------------------------------------");
  }


}
