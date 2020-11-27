package programming.school.framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import programming.school.student.dylan.aroundtheworld.AroundTheWorldIn80Cities;

public class MainRunner extends JFrame {

  private static final long serialVersionUID = -8818261713323847768L;

  private Class<?>[] classes = { programming.school.reference.Lesson1Circles.class,
                                 programming.school.reference.Lesson2Patterns.class,
                                 programming.school.reference.Lesson3Drawing.class,
                                 programming.school.reference.Lesson4ScreenSaver.class,
                                 programming.school.reference.Lesson5Anything.class,
                                 programming.school.reference.Lesson6Adventure.class,
                                 programming.school.reference.Lesson7NewAdventure.class,
                                 programming.school.student.julia.Lesson1Circles.class,
                                 programming.school.student.julia.Lesson2Patterns.class,
                                 programming.school.student.julia.Lesson3Drawing.class,
                                 programming.school.student.julia.Lesson4ScreenSaver.class,
                                 programming.school.student.julia.Lesson5weeeeweeeweewe.class,
                                 programming.school.student.julia.Lesson6Adventure.class,
                                 programming.school.student.julia.Lesson7NewAdventure.class,
                                 programming.school.student.dylan.Lesson1Circles.class,
                                 programming.school.student.dylan.Lesson2Patterns.class,
                                 programming.school.student.dylan.Lesson3Drawing.class,
                                 programming.school.student.dylan.Lesson4ScreenSaver.class,
                                 programming.school.student.dylan.Lesson5CircleRoom.class,
                                 programming.school.student.dylan.Lesson6Adventure.class,
                                 programming.school.student.dylan.Lesson7NewAdventure.class, 
                                 AroundTheWorldIn80Cities.class,
                                 programming.school.student.manca.Lesson1Circles.class,
                                 programming.school.student.manca.Lesson2Patterns.class,
                                 programming.school.student.manca.Lesson3Drawing.class,
                                 programming.school.student.manca.Lesson4ScreenSaver.class,
                                 programming.school.student.manca.Lesson6Adventure.class,
                                 programming.school.student.manca.Lesson7NewAdventure.class, 
                                 programming.school.student.timotej.Lesson1Circles.class,
                                 programming.school.student.timotej.Lesson2Patterns.class,
                                 programming.school.student.timotej.Lesson3Drawing.class,
                                 programming.school.student.timotej.Lesson4ScreenSaver.class,
                                 programming.school.student.timotej.Lesson6Adventure.class,
                                 programming.school.student.timotej.Lesson7NewAdventure.class, 
                                 };

  private static enum MenuMeta {
    FILE_QUIT("File", "Quit", (frame) -> {
      if (frame
          .yesOrNo("Confirm restart",
                   "This will quit the main runner.\n\nAre you sure you wish to quit?"))
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    });

    private String topMenu;
    private String subMenu;
    private Consumer<MainRunner> consumer;

    MenuMeta(String top, String submenu, Consumer<MainRunner> consumer) {
      this.topMenu = top;
      this.subMenu = submenu;
      this.consumer = consumer;
    }

    public String topMenu() {
      return topMenu;
    }

    public String subMenu() {
      return subMenu;
    }

    public Consumer<MainRunner> consumer() {
      return consumer;
    }
  }

  public MainRunner() {
    setSize(800, 600);
    setLocation(100, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setJMenuBar(addStudentItems(createDefaultMenuBar()));
  }

  public boolean yesOrNo(String title, String text) {
    int result = JOptionPane.showConfirmDialog(this,
                                               text,
                                               title,
                                               JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
    return (result == JOptionPane.YES_OPTION);
  }

  private void run(Class<?> target) throws Exception {
    Method m = target.getDeclaredMethod("main", String[].class);
    Object[] args = new Object[1];
    args[0] = new String[0];
    m.invoke(null, args);
  }

  private JMenuBar createDefaultMenuBar() {
    JMenuBar bar = new JMenuBar();
    Map<String, JMenu> topMenus = new HashMap<>();

    for (MenuMeta m : MenuMeta.values()) {
      JMenu jm = topMenus.get(m.topMenu());
      if (jm == null) {
        jm = new JMenu(m.topMenu());
        topMenus.put(m.topMenu(), jm);
        bar.add(jm);
      }

      JMenuItem mi = new JMenuItem(m.subMenu());
      mi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          m.consumer().accept(MainRunner.this);
        }
      });
      jm.add(mi);
    }
    return bar;
  }

  private JMenuBar addStudentItems(JMenuBar b) {
    Map<String, JMenu> menus = new HashMap<>();
    for (Class<?> c : classes) {
      String menuName;
      if ( c.getPackageName().contains("reference")) {
        menuName = "Reference";
      } else if ( c.getPackageName().contains("julia")) {
        menuName = "Julia";
      } else if ( c.getPackageName().contains("dylan")) {
        menuName = "Dylan";
      } else if ( c.getPackageName().contains("manca")) {
        menuName = "Manca";
      } else if ( c.getPackageName().contains("timotej")) {
        menuName = "Timotej";
      } else {
        menuName = "Other";
      }
      JMenu m = menus.get(menuName);
      if (m == null) {
        m = new JMenu(menuName.substring(0, 1).toUpperCase() + menuName.substring(1));
        menus.put(menuName, m);
        b.add(m);
      }
      String itemName = c.getName();
      if ( itemName.contains(".")) {
        itemName = itemName.substring(itemName.lastIndexOf(".")+1);
      }
      JMenuItem mi = new JMenuItem(itemName);
      m.add(mi);
      mi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            run(c);
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(MainRunner.this,
                                          "Error, could not execute target: "
                                                           + ex.getMessage());
          }
        }
      });
    }
    return b;

  }

  public static void main(String[] args) throws Exception {
    new MainRunner().setVisible(true);
  }
}
