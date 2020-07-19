package programming.school.adventure;

import java.net.URL;

public interface IOutput {

  public void println();
  public void println(String message);
  public boolean supportsImages();
  public void image(URL resource);
  
}
