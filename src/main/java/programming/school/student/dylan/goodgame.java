package programming.school.student.dylan;
import javax.swing.*;

public class goodgame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("goodgame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame,
                    "This program contains viral code that will delete files on your desktop. VirusX has shut it down to protect your computer.",
                    "",
                    JOptionPane.WARNING_MESSAGE);

            frame.dispose();
        });
    }
}
