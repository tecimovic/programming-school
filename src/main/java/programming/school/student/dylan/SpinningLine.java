package programming.school.student.dylan;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SpinningLine extends JPanel {

    private double angle = 0;
    private Color lineColor = Color.RED;

    public void animate() {
        Timer timer = new Timer(10, e -> {
            angle += 0.01; // Increment angle for rotation
            lineColor = generateRandomColor(); // Generate a random color

            repaint(); // Refresh the panel
        });
        timer.start();
    }

    private Color generateRandomColor() {
        // Generate random RGB values between 0 and 255
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        return new Color(red, green, blue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 50;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(lineColor);

        double x = centerX + radius * Math.cos(angle);
        double y = centerY + radius * Math.sin(angle);

        g2d.draw(new Line2D.Double(centerX, centerY, x, y));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Spinning Line");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SpinningLine spinningLine = new SpinningLine();
            spinningLine.setPreferredSize(new Dimension(500, 500));
            spinningLine.animate();

            frame.getContentPane().add(spinningLine);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
