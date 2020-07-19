package programming.school.adventure.ui;

import java.io.PrintStream;
import java.net.URL;

import programming.school.adventure.IOutput;

class CliOutput implements IOutput {
  private PrintStream out;
  
  public CliOutput(PrintStream out) {
    this.out = out;
  }
  
  public void println(String message) {
    out.println(message);
  }
  
  public void println() {
    out.println();
  }
  
  @Override
  public boolean supportsImages() {
    return false;
  }
  
  @Override
  public void image(URL resource) {
    // Do  nothing. We don't support that in CLI mode.
  }
  
  @Override
  public boolean supportsSound() {
    return false;
  }
  
  @Override
  public void sound(URL resource) {
    // Do nothing. We don't support that in CLI mode.
  }
}
