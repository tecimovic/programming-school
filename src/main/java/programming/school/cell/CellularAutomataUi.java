package programming.school.cell;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class CellularAutomataUi extends JFrame {

    private static enum MenuMeta {
        FILE_QUIT("File", "Quit", (ui) -> {
            if (ui.yesOrNo("Confirm restart", "This will end the current automata.\n\nAre you sure you wish to quit?"))
                ui.dispatchEvent(new WindowEvent(ui, WindowEvent.WINDOW_CLOSING));
        }),

        EDIT_DRAW_RED("Edit", "Draw red", (ui) -> {
            ui.setDrawingColor(1);
        }),
        EDIT_DRAW_BLUE("Edit", "Draw blue", (ui) -> {
            ui.setDrawingColor(2);
        }),
        GAME_CLEAR("Automaton", "Clear", (ui) -> {
            ui.clearAutomata();
        }),
        GAME_RESTART("Automaton", "One Step", (ui) -> {
            ui.oneStep();
        }),
        GAME_START("Automaton", "Start", (ui) -> {
            ui.runAutomata();
        }),
        GAME_STOP("Automaton", "Stop", (ui) -> {
            ui.stopAutomata();
        });

        private String topMenu;
        private String subMenu;
        private Consumer<CellularAutomataUi> consumer;

        MenuMeta(final String top, final String submenu, final Consumer<CellularAutomataUi> consumer) {
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

        public Consumer<CellularAutomataUi> consumer() {
            return consumer;
        }
    }

    private static final long serialVersionUID = -5593908552783820409L;

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 900;

    private JPanel panel, buttonPanel;
    private JTextField field;
    private SimpleAttributeSet uiStyle;
    private SimpleAttributeSet gameStyle;
    private boolean isButton1;
    private int whatToDraw = 1;

    private ICellularRules rules = new ICellularRules() {

        @Override
        public String name() {
            return "Default rule";
        }

        @Override
        public int width() {
            return 10;
        }

        @Override
        public int height() {
            return 10;
        }

        @Override
        public int newState(final int oldState, final int[] neigbors) {
            return 1 - oldState;
        }

        @Override
        public int initialValue(final int x, final int y) {
            return 0;
        }
    };

    private CellularField cf = new CellularField(rules);

    /**
     * Creates a window with specified title
     * 
     * @param title
     * @param rules
     */
    public CellularAutomataUi(final String title, final ICellularRules... rules) {
        super(title);

        initComponents();

        setJMenuBar(createMenuBar(rules));

        setSize(WIDTH, HEIGHT);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**
     * Creates a window with title "Cellular Automata"
     * 
     * @param rules
     */
    public CellularAutomataUi(final ICellularRules... rules) {
        this("Cellular Automata", rules);
    }

    public boolean yesOrNo(final String title, final String text) {
        int result = JOptionPane.showConfirmDialog(this, text, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return (result == JOptionPane.YES_OPTION);
    }

    public void setRules(final ICellularRules rules) {
        this.rules = rules;
        this.cf = new CellularField(rules);
        panel.repaint();
    }

    public void oneStep() {
        cf.oneStep();
        panel.repaint();
    }

    public void setDrawingColor(final int x) {
        this.whatToDraw = x;
    }

    private JMenuBar createMenuBar(final ICellularRules... rules) {
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
            mi.addActionListener(e -> m.consumer().accept(CellularAutomataUi.this));
            jm.add(mi);
        }

        JMenu jm = topMenus.get("Automaton");
        jm.addSeparator();

        for (ICellularRules r : rules) {
            JMenuItem mi = new JMenuItem(r.name());
            mi.addActionListener(e -> setRules(r));
            jm.add(mi);
        }
        return bar;
    }

    private Font createGameFont() {
        return new Font("Comic Sans MS", Font.BOLD, 18);
    }

    private void redraw(final Graphics g, final int w, final int h) {
        int boxWidth = w / rules.width();
        int boxHeight = h / rules.height();

        for (int x = 0; x < rules.width(); x++) {
            int xCoord = (w * x) / rules.width();
            for (int y = 0; y < rules.height(); y++) {
                int yCoord = (h * y) / rules.height();
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(xCoord, yCoord, boxWidth, boxHeight);
                switch (cf.value(x, y)) {
                    case 0:
                        g.setColor(Color.WHITE);
                        g.fillRect(xCoord + 1, yCoord + 1, boxWidth - 1, boxHeight - 1);
                        break;
                    case 1:
                        g.setColor(Color.RED);
                        g.fillRect(xCoord + 1, yCoord + 1, boxWidth - 1, boxHeight - 1);
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        g.fillRect(xCoord + 1, yCoord + 1, boxWidth - 1, boxHeight - 1);
                        break;
                    case 3:
                        g.setColor(Color.GREEN);
                        g.fillRect(xCoord + 1, yCoord + 1, boxWidth - 1, boxHeight - 1);
                        break;
                    case 4:
                        g.setColor(Color.ORANGE);
                        g.fillRect(xCoord + 1, yCoord + 1, boxWidth - 1, boxHeight - 1);
                        break;
                }
            }
        }
    }

    private void fieldPressed(final int x, final int y, final boolean on) {
        if (on) {
            cf.setValue(x, y, whatToDraw);
        } else {
            cf.setValue(x, y, 0);
        }
        panel.repaint();
    }

    private Thread t = null;

    private void runAutomata() {
        if (t == null) {
            t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        oneStep();
                        try {
                            sleep(100);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            t.start();
        }
    }

    private void stopAutomata() {
        if (t != null) {
            t.stop();
            t = null;
        }
    }

    private void clearAutomata() {
        cf.clear();
    }

    private void initComponents() {
        Font newFont = createGameFont();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton bRun = new JButton();
        bRun.setText("Run");
        bRun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                runAutomata();
            }
        });

        JButton bStop = new JButton();
        bStop.setText("Stop");
        bStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                stopAutomata();
            }
        });

        JButton bOne = new JButton();
        bOne.setText("One step");
        bOne.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                oneStep();
            }
        });

        buttonPanel.add(bRun);
        buttonPanel.add(bStop);
        buttonPanel.add(bOne);

        panel = new JPanel() {

            private static final long serialVersionUID = 7882359471326234775L;

            @Override
            public void paint(final Graphics g) {
                Dimension d = panel.getSize();
                redraw(g, d.width, d.height);
            }
        };

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(final MouseEvent e) {
                Dimension d = panel.getSize();
                int x = e.getX();
                int y = e.getY();
                int i = (x * rules.width()) / d.width;
                int j = (y * rules.height()) / d.height;
                fieldPressed(i, j, isButton1);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                isButton1 = e.getButton() == MouseEvent.BUTTON1;
                Dimension d = panel.getSize();
                int x = e.getX();
                int y = e.getY();
                int i = (x * rules.width()) / d.width;
                int j = (y * rules.height()) / d.height;
                fieldPressed(i, j, isButton1);
            }

        });

        field = new JTextField();

        uiStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(uiStyle, Color.BLUE);
        StyleConstants.setBold(uiStyle, true);

        gameStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(gameStyle, Color.BLACK);
        StyleConstants.setBold(gameStyle, false);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(field, BorderLayout.SOUTH);
        field.setFont(newFont);
        field.requestFocus();

        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                char c = e.getKeyChar();
                if (c == '\n') {
                    String text = field.getText();
                    field.setText("");
                    if (text != null && text.trim().length() > 0) {
                        newCommandTyped(text);
                    }
                }
            }
        });
    }

    private void newCommandTyped(final String text) {
    }

    public void start() {
        setVisible(true);
        panel.repaint();
    }

    public static void main(final String[] args) {
        new CellularAutomataUi().start();
    }
}
