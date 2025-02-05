package assignment_1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamService {

    public void addCandidate(String name, int age) {
        try (Connection c = new DBConnection().dbConnect()) {
            String query = "INSERT INTO candidates (name, age) VALUES (?, ?)";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.executeUpdate();
            System.out.println("Candidate added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCandidate(int id, String name, int age) {
        try (Connection c = new DBConnection().dbConnect()) {
            String query = "UPDATE candidates SET name = ?, age = ? WHERE id = ?";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Candidate updated successfully!");
            } else {
                System.out.println("Candidate not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCandidate(int id) {
        try (Connection c = new DBConnection().dbConnect()) {
            String query = "DELETE FROM candidates WHERE id = ?";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Candidate deleted successfully!");
            } else {
                System.out.println("Candidate not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getCandidates() {
        List<String> candidates = new ArrayList<>();
        try (Connection c = new DBConnection().dbConnect()) {
            String query = "SELECT id, name, age FROM candidates";
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                candidates.add(resultSet.getInt("id") + ") " + resultSet.getString("name") + " - " + resultSet.getInt("age") + " years old");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return candidates;
    }
}
