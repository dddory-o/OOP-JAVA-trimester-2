package assignment_1;

// Extending the abstract Entity class
public class Question extends Entity {
    private String questionText;
    private String correctAnswer;

    public Question(int id, String questionText, String correctAnswer) {
        super(id);
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String getDetails() {
        return "Question: " + questionText + ", Correct Answer: " + correctAnswer;
    }

    @Override
    public String toString() {
        return super.toString() + ", Text: " + questionText;
    }
}

