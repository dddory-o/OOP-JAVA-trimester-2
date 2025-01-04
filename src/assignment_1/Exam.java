package assignment_1;// assignment_1.Exam.java
import java.util.ArrayList;
import java.util.List;

public class Exam {
    private int examId;
    private String title;
    private List<Question> questions;

    public Exam(int examId, String title) {
        this.examId = examId;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "assignment_1.Exam ID: " + examId + ", Title: " + title + ", Questions: " + questions.size();
    }
}

