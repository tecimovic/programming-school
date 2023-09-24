package programming.school.framework;

public interface IMathPlotter {

    String windowTitle();

    int maxX();

    int maxY();

    void plot(CoordinateSystem cs);
}
