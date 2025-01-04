import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    // Constructor
    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    // Getter and Setter for questionText
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    // Getter and Setter for options
    public String[] getOptions() {
        return options;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    // Getter and Setter for correctOption
    public int getCorrectOption() {
        return correctOption;
    }
    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }
    // Method to check if the chosen option is correct
    public boolean isCorrect(int chosenOption) {
        return chosenOption == correctOption;
    }
}

class Candidate {
    private String name;
    private String candidateId;
    private int score;
    // Constructor
    public Candidate(String name, String candidateId) {
        this.name = name;
        this.candidateId = candidateId;
        this.score = 0;
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getter and Setter for candidateId
    public String getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
    // Getter and Setter for score
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}

class Exam {
    private String title;
    private ArrayList<Question> questions;

    // Constructor
    public Exam(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for questions
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // Method to add a question to the exam
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Method to conduct the exam
    public void conductExam(Candidate candidate) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Exam: " + getTitle() + "\n");

        for (Question question : getQuestions()) {
            System.out.println("Question: " + question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter the number of your choice: ");
            int chosenOption;

            try {
                chosenOption = scanner.nextInt() - 1;
                if (question.isCorrect(chosenOption)) {
                    System.out.println("Correct!\n");
                    candidate.setScore(candidate.getScore() + 1);
                } else {
                    System.out.println("Wrong answer.\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.\n");
                scanner.next(); // Clear invalid input
            }
        }

        System.out.println("Exam completed. " + candidate.getName() + "'s Score: " + candidate.getScore() + "\n");
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create Questions
        Question q1 = new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 1);
        Question q2 = new Question("What is 5 + 3?", new String[]{"5", "8", "10", "15"}, 1);

        // Create Exam
        Exam exam = new Exam("General Knowledge Test");
        exam.addQuestion(q1);
        exam.addQuestion(q2);

        // Create Candidate
        Candidate candidate = new Candidate("Alice", "C001");

        // Conduct Exam
        exam.conductExam(candidate);
    }
}





