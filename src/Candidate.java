// Candidate.java
public class Candidate {
    private int candidateId;
    private String name;
    private int score;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.score = 0;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore(int points) {
        this.score += points;
    }

    @Override
    public String toString() {
        return "Candidate ID: " + candidateId + ", Name: " + name + ", Score: " + score;
    }
}
