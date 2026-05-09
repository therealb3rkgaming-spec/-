import javax.swing.*;

public class ConfirmationWindow {
    public static void main(String[] args) {
        // Первый вопрос
        int answer1 = JOptionPane.showConfirmDialog(null, 
                "Вы любите программировать?", 
                "Вопрос 1", 
                JOptionPane.YES_NO_OPTION);
        
        // Второй вопрос
        int answer2 = JOptionPane.showConfirmDialog(null, 
                "Вы любите кофе?", 
                "Вопрос 2", 
                JOptionPane.YES_NO_OPTION);
        
        // Формируем ответ в зависимости от комбинации
        String result;
        
        if (answer1 == JOptionPane.YES_OPTION && answer2 == JOptionPane.YES_OPTION) {
            result = "Вы настоящий программист! Любите кодить под чашечку кофе ☕💻";
        } else if (answer1 == JOptionPane.YES_OPTION && answer2 == JOptionPane.NO_OPTION) {
            result = "Вы любите программировать, но кофе не пьёте. Чай или сок? 🍵😊";
        } else if (answer1 == JOptionPane.NO_OPTION && answer2 == JOptionPane.YES_OPTION) {
            result = "Вы не программист, но кофе любите. Может, пора начать кодить? 😄";
        } else {
            result = "Вы не любите ни программировать, ни кофе. А зря! Это интересно 🚀";
        }
        
        // Показываем результат
        JOptionPane.showMessageDialog(null, 
                result, 
                "Результат опроса", 
                JOptionPane.INFORMATION_MESSAGE);
    }
}
