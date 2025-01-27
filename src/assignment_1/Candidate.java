package assignment_1;

public class Candidate extends Entity {
    private String name;
    private int score;

    public Candidate(int id, String name) {
        super(id);
        this.name = name;
        this.score = 0; // Default score
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        this.score += points;
    }

    @Override
    public String getDetails() {
        return "Candidate: " + name + ", Score: " + score;
    }

    @Override
    public String toString() {
        return super.toString() + ", Name: " + name + ", Score: " + score;
    }
}

