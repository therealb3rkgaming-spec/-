import javax.swing.*;
import java.awt.*;

public class FirstLabel {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Моя первая надпись");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Центрирование
        
        // Создаём надпись
        JLabel label = new JLabel("Моя первая надпись!");
        
        // Создаём шрифт: название, стиль (курсив), размер 50
        Font font = new Font("Segoe Script", Font.ITALIC, 50);
        label.setFont(font);
        
        // Добавляем надпись в центр окна
        frame.add(label);
        
        // Центрируем окно на экране и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
