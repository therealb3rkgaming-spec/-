import javax.swing.*;
import java.awt.*;

public class PasswordRegistration {
    public static void main(String[] args) {
        // 1) Окно с приветствием и предложением зарегистрироваться
        int register = JOptionPane.showConfirmDialog(null,
                "Добро пожаловать! Хотите зарегистрироваться в программе?",
                "Регистрация",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (register != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Программа завершена.");
            return;
        }
        
        // 2) Ввод логина (не менее 6 символов, без пробелов)
        String login = "";
        boolean loginValid = false;
        while (!loginValid) {
            login = JOptionPane.showInputDialog(null,
                    "Введите логин (не менее 6 символов, без пробелов):",
                    "Ввод логина",
                    JOptionPane.QUESTION_MESSAGE);
            
            if (login == null) {
                JOptionPane.showMessageDialog(null, "Регистрация отменена.");
                return;
            }
            
            // Проверка логина
            if (login.length() >= 6 && !login.contains(" ")) {
                loginValid = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Логин должен быть не менее 6 символов и не содержать пробелов!",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // 3) Ввод пароля (не менее 8 символов, без пробелов, хотя бы одна цифра и одна буква)
        String password = "";
        boolean passwordValid = false;
        while (!passwordValid) {
            // Создаём поле для ввода пароля с маскировкой
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Введите пароль (не менее 8 символов, без пробелов, хотя бы 1 цифра и 1 буква):");
            JPasswordField passwordField = new JPasswordField(20);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(label);
            panel.add(passwordField);
            
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Ввод пароля",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if (result != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Регистрация отменена.");
                return;
            }
            
            password = new String(passwordField.getPassword());
            
            // Проверка пароля
            boolean hasDigit = false;
            boolean hasLetter = false;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) hasDigit = true;
                if (Character.isLetter(c)) hasLetter = true;
            }
            
            if (password.length() >= 8 && !password.contains(" ") && hasDigit && hasLetter) {
                passwordValid = true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Пароль должен быть:\n" +
                        "- не менее 8 символов\n" +
                        "- без пробелов\n" +
                        "- содержать хотя бы одну цифру\n" +
                        "- содержать хотя бы одну букву",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // 4) Повтор пароля
        String confirmPassword = "";
        while (true) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Повторите пароль:");
            JPasswordField passwordField = new JPasswordField(20);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(label);
            panel.add(passwordField);
            
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Подтверждение пароля",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if (result != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Регистрация отменена.");
                return;
            }
            
            confirmPassword = new String(passwordField.getPassword());
            
            if (confirmPassword.equals(password)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Пароли не совпадают! Попробуйте снова.",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // 5) Информационное окно об успешной регистрации
        JOptionPane.showMessageDialog(null,
                "Поздравляем, " + login + "!\nВы успешно зарегистрированы!",
                "Регистрация успешна",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
