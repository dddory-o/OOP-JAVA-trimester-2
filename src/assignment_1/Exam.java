package assignment_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exam extends Entity {
    private String title;
    private List<Question> questions;

    public Exam(int id, String title) {
        super(id);
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    // Filter questions by keyword in the question text
    public List<Question> filterQuestions(String keyword) {
        return questions.stream()
                .filter(q -> q.getQuestionText().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Sort questions by ID
    public List<Question> sortQuestionsById() {
        return questions.stream()
                .sorted(Comparator.comparingInt(Entity::getId))
                .collect(Collectors.toList());
    }

    @Override
    public String getDetails() {
        return "Exam Title: " + title + ", Total Questions: " + questions.size();
    }

    @Override
    public String toString() {
        return super.toString() + ", Title: " + title + ", Questions: " + questions.size();
    }
}


