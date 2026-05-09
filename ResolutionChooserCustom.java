import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolutionChooserCustom {
    public static void main(String[] args) {
        // Создаём главное окно (диалог)
        JDialog dialog = new JDialog();
        dialog.setTitle("Выбор разрешения экрана");
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        // Панель с переключателями
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Группа переключателей (чтобы можно было выбрать только один)
        ButtonGroup group = new ButtonGroup();
        
        // Массив доступных разрешений
        String[] resolutions = {
            "800x600",
            "1024x768",
            "1200x600",
            "1280x1024",
            "1680x1050",
            "1920x1080"
        };
        
        // Создаём переключатели
        JRadioButton[] radioButtons = new JRadioButton[resolutions.length];
        for (int i = 0; i < resolutions.length; i++) {
            radioButtons[i] = new JRadioButton(resolutions[i]);
            group.add(radioButtons[i]);
            radioPanel.add(radioButtons[i]);
        }
        
        // Выбираем первый по умолчанию
        radioButtons[0].setSelected(true);
        
        // Панель с кнопкой OK
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        
        // Добавляем панели в диалог
        dialog.add(radioPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        
        // Обработчик кнопки OK
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = null;
                for (JRadioButton rb : radioButtons) {
                    if (rb.isSelected()) {
                        selected = rb.getText();
                        break;
                    }
                }
                
                if (selected != null) {
                    String[] dimensions = selected.split("x");
                    int width = Integer.parseInt(dimensions[0]);
                    int height = Integer.parseInt(dimensions[1]);
                    
                    dialog.dispose(); // Закрываем диалог
                    
                    // Создаём окно с выбранным разрешением
                    JFrame frame = new JFrame("Окно " + selected);
                    frame.setSize(width, height);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });
        
        // Настройка и показ диалога
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
