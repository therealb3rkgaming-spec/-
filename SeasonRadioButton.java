import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeasonRadioButton {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Выбор любимого времени года");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Панель для радиокнопок
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(4, 1));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        // Создаём радиокнопки
        JRadioButton spring = new JRadioButton("Весна");
        JRadioButton summer = new JRadioButton("Лето");
        JRadioButton autumn = new JRadioButton("Осень");
        JRadioButton winter = new JRadioButton("Зима");
        
        // Объединяем в группу (чтобы можно было выбрать только один вариант)
        ButtonGroup group = new ButtonGroup();
        group.add(spring);
        group.add(summer);
        group.add(autumn);
        group.add(winter);
        
        // Добавляем радиокнопки на панель
        radioPanel.add(spring);
        radioPanel.add(summer);
        radioPanel.add(autumn);
        radioPanel.add(winter);
        
        // Выбираем Осень по умолчанию (как на картинке)
        autumn.setSelected(true);
        
        // Панель для кнопки и ответа
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        JButton answerButton = new JButton("Ответить");
        JLabel answerLabel = new JLabel("Ответ: ");
        answerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Обработчик кнопки
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSeason = "";
                if (spring.isSelected()) selectedSeason = "Весна";
                else if (summer.isSelected()) selectedSeason = "Лето";
                else if (autumn.isSelected()) selectedSeason = "Осень";
                else if (winter.isSelected()) selectedSeason = "Зима";
                
                answerLabel.setText("Ответ: " + selectedSeason);
            }
        });
        
        bottomPanel.add(answerButton);
        bottomPanel.add(answerLabel);
        
        // Добавляем панели в окно
        frame.add(radioPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
