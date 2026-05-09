import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String currentNumber = "";
    private String lastNumber = "";
    private String operator = "";
    private boolean startNewNumber = true;
    
    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());
        
        // Поле для отображения
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        
        // Панель с кнопками
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Массив кнопок в порядке расположения на калькуляторе
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        
        // Создаём и добавляем кнопки
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        // Обработка цифр
        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                currentNumber = command;
                startNewNumber = false;
            } else {
                currentNumber += command;
            }
            display.setText(currentNumber);
        }
        // Обработка операторов
        else if (command.equals("+") || command.equals("-") || 
                 command.equals("*") || command.equals("/")) {
            if (!operator.isEmpty() && !startNewNumber) {
                calculate();
            }
            lastNumber = currentNumber;
            operator = command;
            startNewNumber = true;
        }
        // Обработка равенства
        else if (command.equals("=")) {
            if (!operator.isEmpty() && !startNewNumber) {
                calculate();
                operator = "";
                startNewNumber = true;
            }
        }
        // Обработка очистки
        else if (command.equals("C")) {
            currentNumber = "";
            lastNumber = "";
            operator = "";
            startNewNumber = true;
            display.setText("");
        }
    }
    
    private void calculate() {
        double num1 = Double.parseDouble(lastNumber);
        double num2 = Double.parseDouble(currentNumber);
        double result = 0;
        
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    display.setText("Ошибка: деление на 0");
                    currentNumber = "";
                    lastNumber = "";
                    operator = "";
                    startNewNumber = true;
                    return;
                }
                result = num1 / num2;
                break;
        }
        
        // Форматируем результат (убираем .0 если число целое)
        if (result == (long) result) {
            currentNumber = String.valueOf((long) result);
        } else {
            currentNumber = String.valueOf(result);
        }
        display.setText(currentNumber);
    }
    
    public static void main(String[] args) {
        new Calculator();
    }
}
