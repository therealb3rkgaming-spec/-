import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSpinner {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Выбор количества книг");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Панель для спиннера и метки
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        // Добавляем метку
        JLabel questionLabel = new JLabel("Сколько книг вы возьмёте с собой в лагерь?");
        topPanel.add(questionLabel);
        
        // Создаём JSpinner (от 0 до 100, начальное значение 11)
        SpinnerNumberModel model = new SpinnerNumberModel(11, 0, 100, 1);
        JSpinner spinner = new JSpinner(model);
        topPanel.add(spinner);
        
        // Панель для кнопки и ответа
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        // Кнопка "Ответить"
        JButton button = new JButton("Ответить");
        
        // Надпись для вывода ответа
        JLabel answerLabel = new JLabel("Ответ: ");
        answerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Обработчик кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = (int) spinner.getValue();
                answerLabel.setText("Ответ: " + value);
            }
        });
        
        bottomPanel.add(button);
        bottomPanel.add(answerLabel);
        
        // Добавляем панели в окно
        frame.add(topPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
