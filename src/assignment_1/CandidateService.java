package assignment_1;

import java.util.List;

public class CandidateService {
    private final CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public void addCandidate(String name) {
        repository.add(new Candidate(0, name, 0));
    }

    public void updateCandidate(int id, String name, int score) {
        repository.update(new Candidate(id, name, score));
    }

    public void deleteCandidate(int id) {
        repository.delete(id);
    }

    public List<Candidate> getCandidates() {
        return repository.getAll();
    }
}
