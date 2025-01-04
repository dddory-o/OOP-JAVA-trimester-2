import java.util.ArrayList;
import java.util.Scanner;

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
        return title+"exam";
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
