import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaApp {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("JTextArea Пример");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Панель для ввода текста
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel inputLabel = new JLabel("Введите строку:");
        JTextField textField = new JTextField(20);
        JButton writeButton = new JButton("Записать");
        
        topPanel.add(inputLabel);
        topPanel.add(textField);
        topPanel.add(writeButton);
        
        // Панель для JTextArea с прокруткой
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Список строк"));
        
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        // Добавляем полосы прокрутки
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Нижняя панель с дополнительной кнопкой
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        JButton newLineButton = new JButton("Новая строка");
        
        bottomPanel.add(newLineButton);
        
        // Обработчик кнопки "Записать"
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (!text.isEmpty()) {
                    textArea.append(text + "\n");
                    textField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, 
                        "Пожалуйста, введите текст!", 
                        "Предупреждение", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Обработчик кнопки "Новая строка" (добавляет пустую строку)
        newLineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("\n");
            }
        });
        
        // Добавляем панели в окно
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
