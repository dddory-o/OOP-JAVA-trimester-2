package assignment_1;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var examService = new ExamService();
        System.out.println("ALL EXAMS WE HAVE: ");

        for (Exam e : examService.getExams()) {
            System.out.println(e.getTitle() + " " + e.getId());
        }

        System.out.println("SO IF WE LOOK QUESTIONS: ");

        for (Exam exam : examService.getExams()) {
            var questions = examService.getQuestions(exam.getId());
            System.out.println("EXAM NUMBER: " + exam.getId() + " HAVE THIS QUESTIONS");

            for (Question q : questions) {
                System.out.println(q.getId()+") "+q.getQuestionText());
                System.out.println("ENTER YOUR ANSWER: ");
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();
                if (userAnswer.equals(q.getCorrectAnswer())) {
                    System.out.println("CORRECT ANSWER");
                } else {
                    System.out.println("WRONG ANSWER CORRECT ANSWER IS: " + q.getCorrectAnswer());
                }
            }
        }

        System.out.println("THANK YOU FOR YOUR TIME");
    }
}