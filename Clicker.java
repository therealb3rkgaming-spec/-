import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker {
    private int clickCount = 0;
    private JLabel countLabel;
    
    public Clicker() {
        // Создаём окно
        JFrame frame = new JFrame("Кликер");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Создаём надпись для отображения количества кликов
        countLabel = new JLabel("Нажатий: 0", SwingConstants.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Создаём кнопку
        JButton button = new JButton("Нажми меня!");
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        
        // Обработчик нажатия кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                countLabel.setText("Нажатий: " + clickCount);
            }
        });
        
        // Добавляем компоненты в окно
        frame.add(countLabel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Clicker();
    }
}
