package assignment_1;

public interface ScoringStrategy {
    int calculateScore(int correctAnswers);
}

class SimpleScoring implements ScoringStrategy {
    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 10;
    }
}

class ComplexScoring implements ScoringStrategy {
    @Override
    public int calculateScore(int correctAnswers) {
        return correctAnswers * 5 + 20;
    }
}
