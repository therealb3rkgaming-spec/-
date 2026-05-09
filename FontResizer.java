import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FontResizer {
    public static void main(String[] args) {
        // Создаём окно
        JFrame frame = new JFrame("Изменение шрифта надписи");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Создаём надпись
        JLabel label = new JLabel("Моя первая надпись!", SwingConstants.CENTER);
        Font initialFont = new Font("Segoe Script", Font.ITALIC, 50);
        label.setFont(initialFont);
        
        // Создаём слайдер (от 5 до 100, начальное значение 50)
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        
        // Добавляем метку для отображения текущего размера
        JLabel sizeLabel = new JLabel("Размер шрифта: 50", SwingConstants.CENTER);
        
        // Обработчик изменения слайдера
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = slider.getValue();
                Font newFont = new Font(label.getFont().getName(), label.getFont().getStyle(), fontSize);
                label.setFont(newFont);
                sizeLabel.setText("Размер шрифта: " + fontSize);
            }
        });
        
        // Панель для слайдера и метки
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(slider, BorderLayout.CENTER);
        controlPanel.add(sizeLabel, BorderLayout.SOUTH);
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Добавляем компоненты в окно
        frame.add(label, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        
        // Центрируем окно и показываем
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
