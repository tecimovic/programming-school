package programming.school.adventure.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import programming.school.adventure.IAdventureGame;
import programming.school.adventure.IOutput;
import programming.school.adventure.Player;

public class GameUi extends JFrame implements IOutput {

  private static final long serialVersionUID = -5593908552783820409L;
 
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 900;
  
  private JTextPane pane;
  private JScrollPane scrollPane;
  private JTextField field;
  private StyledDocument doc;
  private Player player;
  private SimpleAttributeSet uiStyle;
  private SimpleAttributeSet gameStyle;
  private IAdventureGame game;

  public GameUi(IAdventureGame game) {
    super("Adventure game");

    this.game = game;
    this.player = new Player(this, game);

    initComponents();

    setSize(WIDTH, HEIGHT);
    setLocation(100, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void appendText(String txt, AttributeSet as) {
    try {
      doc.insertString(doc.getLength(), txt, as);
      pane.setCaretPosition(doc.getLength());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void println() {
    println("");
  }

  @Override
  public void println(String message) {
    appendText(message + "\n", gameStyle);
  }

  public void uiPrintln(String message) {
    appendText(message + "\n", uiStyle);
  }

  @Override
  public boolean supportsImages() {
    return true;
  }

  @Override
  public boolean supportsSound() {
    return true;
  }

  @Override
  public void sound(URL resource) {
    Sounds.play(resource);
  }

  @Override
  public void image(URL resource) {
    String key = resource.toString();
    Style s = doc.getStyle(key);
    if (s == null) {
      s = doc.addStyle(key, null);
      ImageIcon icon = new ImageIcon(resource);
      StyleConstants.setIcon(s, icon);
    }
    appendText("image placeholder", s);
    appendText("\n", uiStyle);
  }

  private void restart() {
    try {
      doc.remove(0, doc.getLength());
    } catch (Exception e) {
      // never mind
    }
    this.player = new Player(this, game);
    player.intro();
    player.describeCurrentPlace();
  }

  private void initComponents() {
    pane = new JTextPane();
    scrollPane = new JScrollPane(pane);
    doc = pane.getStyledDocument();
    field = new JTextField();

    uiStyle = new SimpleAttributeSet();
    StyleConstants.setForeground(uiStyle, Color.BLUE);
    StyleConstants.setBold(uiStyle, true);

    gameStyle = new SimpleAttributeSet();
    StyleConstants.setForeground(gameStyle, Color.BLACK);
    StyleConstants.setBold(gameStyle, false);

    setLayout(new BorderLayout());
    add(scrollPane, BorderLayout.CENTER);
    add(field, BorderLayout.SOUTH);
    pane.setFocusable(false);
    field.requestFocus();

    field.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c == '\n') {
          String text = field.getText();
          field.setText("");
          if (text != null && text.trim().length() > 0) {
            uiPrintln("\n> " + text);
            newCommandTyped(text);
          }
        }
      }
    });

    player.intro();
    player.describeCurrentPlace();
  }
  
  private void newCommandTyped(String text) {
    Sounds.clear();
    if (!player.isGameOver()) {
      player.newCommand(text);
    } else {
      if ("restart".equals(text)) {
        restart();
        return;
      } else {
        uiPrintln("You can type 'restart' to start a new game.");
      }
    }

    if (player.isGameOver()) {
      player.gameOver();
    } else {
      player.describeCurrentPlace();
    }    
  }

  public void start() {
    setVisible(true);
  }
}
