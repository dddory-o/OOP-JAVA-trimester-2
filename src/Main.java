// Main.java
public class Main {
    public static void main(String[] args) {
        // Create questions
        Question q1 = new Question(1, "What is 2 + 2?", "4");
        Question q2 = new Question(2, "What is the capital of France?", "Paris");

        // Create a candidate
        Candidate candidate = new Candidate(101, "Alice");

        // Create an exam and add questions
        Exam exam = new Exam(201, "General Knowledge Test");
        exam.addQuestion(q1);
        exam.addQuestion(q2);

        // Output the exam, candidate, and questions
        System.out.println("Exam Details:");
        System.out.println(exam);

        System.out.println("\nCandidate Details:");
        System.out.println(candidate);

        System.out.println("\nQuestions:");
        for (Question q : exam.getQuestions()) {
            System.out.println(q);
        }

        // Simulate candidate answering questions
        System.out.println("\nAnswering Questions:");
        if ("4".equals(q1.getCorrectAnswer())) {
            candidate.updateScore(10);
        }
        if ("Paris".equals(q2.getCorrectAnswer())) {
            candidate.updateScore(10);
        }

        // Output updated candidate score
        System.out.println("\nUpdated Candidate Details:");
        System.out.println(candidate);
    }
}






