import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Простое окно");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(frame, "Алексей Петров"); // замените на своё имя
                }
            }
        });

        frame.setFocusable(true);
        frame.setVisible(true);
    }
}
