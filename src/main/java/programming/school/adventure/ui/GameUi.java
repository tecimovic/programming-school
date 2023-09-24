package programming.school.adventure.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

    private static enum MenuMeta {
        FILE_QUIT("File", "Quit", (gameUi) -> {
            if (gameUi
                    .yesOrNo("Confirm restart",
                            "This will end the current game.\n\nAre you sure you wish to quit?"))
                gameUi
                        .dispatchEvent(new WindowEvent(gameUi, WindowEvent.WINDOW_CLOSING));
        }),

        GAME_RESTART("Game", "Restart", (gameUi) -> {
            if (gameUi
                    .yesOrNo("Confirm restart",
                            "This will end the current game.\n\nAre you sure you wish to do this?"))
                gameUi.startGame(true);
        });

        private String topMenu;
        private String subMenu;
        private Consumer<GameUi> consumer;

        MenuMeta(String top, String submenu, Consumer<GameUi> consumer) {
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

        public Consumer<GameUi> consumer() {
            return consumer;
        }
    }

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
    private Class<? extends IAdventureGame> gameClass;

    public GameUi(IAdventureGame game) {
        super(game.windowTitle());

        initComponents();

        setJMenuBar(createMenuBar());

        setSize(WIDTH, HEIGHT);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.gameClass = game.getClass();
        startGame(false);
    }

    @Override
    public void setWindowTitle(String title) {
        setTitle(title);
    }

    public boolean yesOrNo(String title, String text) {
        int result = JOptionPane.showConfirmDialog(this,
                text,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return (result == JOptionPane.YES_OPTION);
    }

    private void startGame(boolean isRestart) {
        IAdventureGame game;
        try {
            game = gameClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Could not create game: "
                    + gameClass.getName());
        }
        this.player = new Player(this, game);
        this.player.setAllowGoShortcut(game.allowGoShortcut());
        if (isRestart) {
            try {
                doc.remove(0, doc.getLength());
            } catch (Exception e) {
                // never mind
            }
            this.player.out().println("--- Game has been restarted ---");
        }
        player.intro();
        player.describeCurrentPlace();
    }

    private JMenuBar createMenuBar() {
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
                    m.consumer().accept(GameUi.this);
                }
            });
            jm.add(mi);
        }
        return bar;
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

    private Font createGameFont() {
        return new Font("Comic Sans MS", Font.BOLD, 18);
    }

    private void initComponents() {
        Font newFont = createGameFont();

        pane = new JTextPane();
        pane.setFont(newFont);
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
        field.setFont(newFont);

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
    }

    private void newCommandTyped(String text) {
        Sounds.clear();
        if (!player.isGameOver()) {
            player.newCommand(text);
        } else {
            if ("restart".equals(text)) {
                startGame(true);
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
