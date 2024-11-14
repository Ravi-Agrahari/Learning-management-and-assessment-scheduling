package DAO;

import Models.Assessment;
import Utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssessmentDAOImpl implements AssessmentDAO {

    // Add assessment for a course
    @Override
    public void addAssessment(Assessment assessment) throws Exception {
        String sql = "INSERT INTO Assessments (course_id, assessment_type, scheduled_date, scheduled_time) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, assessment.getCourseId());
            stmt.setString(2, assessment.getAssessmentType());
            stmt.setDate(3, assessment.getScheduledDate());
            stmt.setTime(4, assessment.getScheduledTime());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error adding assessment", e);
        }
    }

    // Retrieve assessment by assessment ID
    @Override
    public Assessment getAssessmentById(int assessmentId) throws Exception {
        String sql = "SELECT * FROM Assessments WHERE assessment_id = ?";
        Assessment assessment = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, assessmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    assessment = new Assessment(
                        rs.getInt("assessment_id"),
                        rs.getInt("course_id"),
                        rs.getString("assessment_type"),
                        rs.getDate("scheduled_date"),
                        rs.getTime("scheduled_time")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving assessment by ID", e);
        }

        return assessment;
    }

    // Retrieve assessments by course ID
    @Override
    public List<Assessment> getAssessmentsByCourseId(int courseId) throws Exception {
        String sql = "SELECT * FROM Assessments WHERE course_id = ?";
        List<Assessment> assessmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Assessment assessment = new Assessment(
                        rs.getInt("assessment_id"),
                        rs.getInt("course_id"),
                        rs.getString("assessment_type"),
                        rs.getDate("scheduled_date"),
                        rs.getTime("scheduled_time")
                    );
                    assessmentList.add(assessment);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving assessments by course ID", e);
        }

        return assessmentList;
    }

    // Retrieve all assessments
    @Override
    public List<Assessment> getAllAssessments() throws Exception {
        String sql = "SELECT * FROM Assessments";
        List<Assessment> assessmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Assessment assessment = new Assessment(
                    rs.getInt("assessment_id"),
                    rs.getInt("course_id"),
                    rs.getString("assessment_type"),
                    rs.getDate("scheduled_date"),
                    rs.getTime("scheduled_time")
                );
                assessmentList.add(assessment);
            }

        } catch (SQLException e) {
            throw new Exception("Error retrieving all assessments", e);
        }

        return assessmentList;
    }

    // Update assessment
    @Override
    public void updateAssessment(Assessment assessment) throws Exception {
        String sql = "UPDATE Assessments SET course_id = ?, assessment_type = ?, scheduled_date = ?, scheduled_time = ? WHERE assessment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, assessment.getCourseId());
            stmt.setString(2, assessment.getAssessmentType());
            stmt.setDate(3, assessment.getScheduledDate());
            stmt.setTime(4, assessment.getScheduledTime());
            stmt.setInt(5, assessment.getAssessmentId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error updating assessment", e);
        }
    }

    // Delete assessment by assessment ID
    @Override
    public void deleteAssessment(int assessmentId) throws Exception {
        String sql = "DELETE FROM Assessments WHERE assessment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, assessmentId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error deleting assessment", e);
        }
    }
}
