package assignment_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamService {
    public List<Exam> getExams() {
        DBConnection con = new DBConnection();
        try (Connection c = con.dbConnect()){

            String query = "SELECT id, title FROM exam";
            PreparedStatement statement = c.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            var exams = new ArrayList<Exam>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                exams.add(new Exam(id, title));
            }

            return exams;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Question> getQuestions(int examId) {
        try {
            DBConnection con = new DBConnection();
            Connection c = con.dbConnect();

            String query = "SELECT id, question_text, question_answer FROM question WHERE exam_id = ?";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setInt(1, examId);

            ResultSet resultSet = statement.executeQuery();

            List<Question> questions = new ArrayList<Question>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String questionText = resultSet.getString("question_text");
                String correctAnswer = resultSet.getString("question_answer");
                questions.add(new Question(id, questionText, correctAnswer));
            }
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addExam(Exam exam) {
        try {
            DBConnection con = new DBConnection();
            Connection c = con.dbConnect();

            String query = "INSERT INTO exam (title) VALUES (?)";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, exam.getTitle());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addQuestion(Question question, int examId) {
        try {
            DBConnection con = new DBConnection();
            Connection c = con.dbConnect();

            String query = "INSERT INTO question (question_text, correct_answer, exam_id) VALUES (?, ?, ?)";
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, question.getQuestionText());
            statement.setString(2, question.getCorrectAnswer());
            statement.setInt(3, examId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}