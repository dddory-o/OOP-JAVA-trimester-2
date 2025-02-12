package assignment_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateRepository extends Repository<Candidate> {

    @Override
    public void add(Candidate candidate) {
        String query = "INSERT INTO candidates (name, score) VALUES (?, ?)";
        try (Connection c = getConnection();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, candidate.getName());
            stmt.setInt(2, candidate.getScore());
            stmt.executeUpdate();
            System.out.println("Candidate added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Error adding candidate", e);
        }
    }

    @Override
    public void update(Candidate candidate) {
        String query = "UPDATE candidates SET name = ?, score = ? WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, candidate.getName());
            stmt.setInt(2, candidate.getScore());
            stmt.setInt(3, candidate.getId());
            stmt.executeUpdate();
            System.out.println("Candidate updated successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Error updating candidate", e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM candidates WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Candidate deleted successfully.");
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting candidate", e);
        }
    }

    @Override
    public List<Candidate> getAll() {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates";
        try (Connection c = getConnection();
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                candidates.add(new Candidate(rs.getInt("id"), rs.getString("name"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving candidates", e);
        }
        return candidates;
    }
}

