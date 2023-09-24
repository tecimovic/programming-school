package programming.school.adventure;

import java.net.URL;

public interface IExaminable {

    public String description();

    public boolean hasSound();

    public URL sound();

    public boolean hasPicture();

    public URL picture();
}
