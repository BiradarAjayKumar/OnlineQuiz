import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String text;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String text, ArrayList<String> options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int totalQuestions = questions.size();

        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getText());
            ArrayList<String> options = currentQuestion.getOptions();

            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + totalQuestions);
    }
}

public class QuizPlatform {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Example questions
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C++");
        Question question1 = new Question("Which programming language is known for its portability?", options1, 1);
        quiz.addQuestion(question1);

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("HTML");
        options2.add("CSS");
        options2.add("JavaScript");
        Question question2 = new Question("Which technology is used for building the structure of a web page?", options2, 1);
        quiz.addQuestion(question2);

        // Add more questions as needed

        // Start the quiz
        quiz.startQuiz();
    }
}
