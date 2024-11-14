package DAO;

import Models.Marks;
import Utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAOImpl implements MarksDAO {

    // Add marks for a student
    @Override
    public void addMarks(Marks marks) throws Exception {
        String sql = "INSERT INTO Marks (student_id, assessment_id, marks_obtained, max_marks) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, marks.getStudentId());
            stmt.setInt(2, marks.getAssessmentId());
            stmt.setInt(3, marks.getMarksObtained());
            stmt.setInt(4, marks.getMaxMarks());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error adding marks", e);
        }
    }

    // Retrieve marks by mark ID
    @Override
    public Marks getMarksById(int markId) throws Exception {
        String sql = "SELECT * FROM Marks WHERE mark_id = ?";
        Marks marks = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, markId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    marks = new Marks(
                        rs.getInt("mark_id"),
                        rs.getInt("student_id"),
                        rs.getInt("assessment_id"),
                        rs.getInt("marks_obtained"),
                        rs.getInt("max_marks")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving marks by ID", e);
        }

        return marks;
    }

    // Retrieve marks by student ID
    @Override
    public List<Marks> getMarksByStudentId(int studentId) throws Exception {
        String sql = "SELECT * FROM Marks WHERE student_id = ?";
        List<Marks> marksList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Marks marks = new Marks(
                        rs.getInt("mark_id"),
                        rs.getInt("student_id"),
                        rs.getInt("assessment_id"),
                        rs.getInt("marks_obtained"),
                        rs.getInt("max_marks")
                    );
                    marksList.add(marks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving marks by student ID", e);
        }

        return marksList;
    }

    // Retrieve all marks
    @Override
    public List<Marks> getAllMarks() throws Exception {
        String sql = "SELECT * FROM Marks";
        List<Marks> marksList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Marks marks = new Marks(
                    rs.getInt("mark_id"),
                    rs.getInt("student_id"),
                    rs.getInt("assessment_id"),
                    rs.getInt("marks_obtained"),
                    rs.getInt("max_marks")
                );
                marksList.add(marks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving all marks", e);
        }

        return marksList;
    }

    // Update marks
    @Override
    public void updateMarks(Marks marks) throws Exception {
        String sql = "UPDATE Marks SET student_id = ?, assessment_id = ?, marks_obtained = ?, max_marks = ? WHERE mark_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, marks.getStudentId());
            stmt.setInt(2, marks.getAssessmentId());
            stmt.setInt(3, marks.getMarksObtained());
            stmt.setInt(4, marks.getMaxMarks());
            stmt.setInt(5, marks.getMarkId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error updating marks", e);
        }
    }

    // Delete marks by mark ID
    @Override
    public void deleteMarks(int markId) throws Exception {
        String sql = "DELETE FROM Marks WHERE mark_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, markId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error deleting marks", e);
        }
    }
}
