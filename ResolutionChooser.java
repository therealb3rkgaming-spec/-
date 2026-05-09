import javax.swing.*;
import java.awt.*;

public class ResolutionChooser {
    public static void main(String[] args) {
        // Массив доступных разрешений
        String[] resolutions = {
            "800x600",
            "1024x768",
            "1200x900",
            "1280x1024",
            "1600x1200",
            "1920x1080"
        };
        
        // Создаём выпадающий список (комбобокс)
        JComboBox<String> comboBox = new JComboBox<>(resolutions);
        
        // Создаём панель для размещения компонентов
        JPanel panel = new JPanel();
        panel.add(new JLabel("Выберите разрешение:"));
        panel.add(comboBox);
        
        // Показываем диалоговое окно
        int result = JOptionPane.showConfirmDialog(
            null, 
            panel, 
            "Выбор разрешения экрана", 
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        // Если пользователь нажал OK
        if (result == JOptionPane.OK_OPTION) {
            String selected = (String) comboBox.getSelectedItem();
            String[] dimensions = selected.split("x");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            
            // Создаём окно с выбранным разрешением
            JFrame frame = new JFrame("Окно " + selected);
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // Центрируем окно
            frame.setVisible(true);
        } else {
            // Если пользователь нажал Cancel или закрыл окно
            System.out.println("Выбор разрешения отменён");
        }
    }
}
