import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorComboBox {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Выбор любимого цвета");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Панель для выпадающего списка
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel comboLabel = new JLabel("Выберите любимый цвет:");
        topPanel.add(comboLabel);
        
        // Выпадающий список с цветами
        String[] colors = {"Красный", "Синий", "Зелёный", "Жёлтый", "Фиолетовый"};
        JComboBox<String> comboBox = new JComboBox<>(colors);
        topPanel.add(comboBox);
        
        // Панель для своего варианта
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout());
        
        JCheckBox customCheckBox = new JCheckBox("Свой вариант");
        JTextField customTextField = new JTextField(15);
        customTextField.setEnabled(false);
        customTextField.setForeground(Color.GRAY);
        customTextField.setText("Введите свой цвет...");
        
        // Обработчик для чекбокса
        customCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
                customTextField.setEnabled(selected);
                comboBox.setEnabled(!selected);
                if (selected) {
                    customTextField.requestFocus();
                }
            }
        });
        
        // Обработчик для текстового поля (плейсхолдер)
        customTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (customTextField.getText().equals("Введите свой цвет...")) {
                    customTextField.setText("");
                    customTextField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (customTextField.getText().isEmpty()) {
                    customTextField.setForeground(Color.GRAY);
                    customTextField.setText("Введите свой цвет...");
                }
            }
        });
        
        middlePanel.add(customCheckBox);
        middlePanel.add(customTextField);
        
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
                String selectedColor;
                if (customCheckBox.isSelected() && !customTextField.getText().equals("Введите свой цвет...") 
                        && !customTextField.getText().isEmpty()) {
                    selectedColor = customTextField.getText();
                } else {
                    selectedColor = (String) comboBox.getSelectedItem();
                }
                answerLabel.setText("Ответ: " + selectedColor);
            }
        });
        
        bottomPanel.add(answerButton);
        bottomPanel.add(answerLabel);
        
        // Добавляем панели в окно
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
