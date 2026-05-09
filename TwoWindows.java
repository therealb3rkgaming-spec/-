import javax.swing.*;

public class TwoWindows {
    public static void main(String[] args) {
        // Первое диалоговое окно с полем для ввода имени
        String name = JOptionPane.showInputDialog(null, "Введите ваше имя:", "Ввод имени", JOptionPane.QUESTION_MESSAGE);
        
        // Если пользователь нажал Cancel или закрыл окно, выходим
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Вы не ввели имя. Программа завершена.");
            return;
        }
        
        // Второе информационное окно с приветствием
        JOptionPane.showMessageDialog(null, "Привет, " + name + "!", "Приветствие", JOptionPane.INFORMATION_MESSAGE);
    }
}
