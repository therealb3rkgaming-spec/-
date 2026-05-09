import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Quiz extends JFrame {
    private int currentQuestion = 0;
    private int score = 0;
    private ArrayList<Question> questions;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton nextButton;
    private JLabel progressLabel;
    
    public Quiz() {
        setTitle("Викторина");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        // Инициализация вопросов
        initQuestions();
        
        // Верхняя панель с прогрессом
        JPanel topPanel = new JPanel();
        progressLabel = new JLabel();
        progressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(progressLabel);
        add(topPanel, BorderLayout.NORTH);
        
        // Центральная панель с вопросом и вариантами
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(questionLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Панель для вариантов ответов
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Arial", Font.PLAIN, 14));
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        centerPanel.add(optionsPanel);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // Нижняя панель с кнопкой
        JPanel bottomPanel = new JPanel();
        nextButton = new JButton("Далее");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                loadNextQuestion();
            }
        });
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Загружаем первый вопрос
        loadQuestion();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initQuestions() {
        questions = new ArrayList<>();
        
        // Вопрос 1
        questions.add(new Question(
            "Какой язык программирования используется для создания приложений на Android?",
            new String[]{"Swift", "Python", "Java", "C++"},
            2  // Java (индекс 2, считая с 0)
        ));
        
        // Вопрос 2
        questions.add(new Question(
            "Что означает аббревиатура HTML?",
            new String[]{"Home Tool Markup Language", "Hyper Text Markup Language", "Hyperlinks Text Mark Language", "High Technical Markup Language"},
            1
        ));
        
        // Вопрос 3
        questions.add(new Question(
            "Кто написал первый язык программирования высокого уровня?",
            new String[]{"Билл Гейтс", "Ада Лавлейс", "Алан Тьюринг", "Деннис Ритчи"},
            1
        ));
        
        // Вопрос 4
        questions.add(new Question(
            "Что такое IDE?",
            new String[]{"Integrated Development Environment", "Internet Data Exchange", "Internal Drive Engine", "Interactive Development Editor"},
            0
        ));
        
        // Вопрос 5
        questions.add(new Question(
            "Как называется процесс поиска и исправления ошибок в программе?",
            new String[]{"Компиляция", "Отладка (Debugging)", "Тестирование", "Оптимизация"},
            1
        ));
        
        // Вопрос 6
        questions.add(new Question(
            "Какой оператор используется для вывода данных в Java?",
            new String[]{"print()", "System.out.println()", "console.log()", "echo()"},
            1
        ));
    }
    
    private void loadQuestion() {
        if (currentQuestion < questions.size()) {
            Question q = questions.get(currentQuestion);
            questionLabel.setText(q.getText());
            String[] answers = q.getAnswers();
            for (int i = 0; i < 4; i++) {
                options[i].setText(answers[i]);
                options[i].setSelected(false);
            }
            group.clearSelection();
            progressLabel.setText("Вопрос " + (currentQuestion + 1) + " из " + questions.size());
            nextButton.setText(currentQuestion == questions.size() - 1 ? "Завершить" : "Далее");
        }
    }
    
    private void checkAnswer() {
        if (currentQuestion < questions.size()) {
            int selected = -1;
            for (int i = 0; i < options.length; i++) {
                if (options[i].isSelected()) {
                    selected = i;
                    break;
                }
            }
            if (selected != -1 && selected == questions.get(currentQuestion).getCorrectIndex()) {
                score++;
            }
        }
    }
    
    private void loadNextQuestion() {
        currentQuestion++;
        if (currentQuestion < questions.size()) {
            loadQuestion();
        } else {
            // Викторина завершена
            String message = "Вы набрали " + score + " баллов из " + questions.size() + "\n";
            if (score == questions.size()) {
                message += "Отлично! Вы знаток!";
            } else if (score >= questions.size() / 2) {
                message += "Неплохо, но можно и лучше!";
            } else {
                message += "Попробуйте ещё раз, у вас всё получится!";
            }
            JOptionPane.showMessageDialog(this, message, "Результат викторины", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new Quiz();
    }
}

// Класс для хранения вопроса
class Question {
    private String text;
    private String[] answers;
    private int correctIndex;
    
    public Question(String text, String[] answers, int correctIndex) {
        this.text = text;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }
    
    public String getText() { return text; }
    public String[] getAnswers() { return answers; }
    public int getCorrectIndex() { return correctIndex; }
}
