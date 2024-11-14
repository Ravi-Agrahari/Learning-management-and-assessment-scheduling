package DAO;

import Models.Course;
import Models.Enrollment;
import Utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {

    // Add enrollment for a student in a course
    @Override
    public void addEnrollment(Enrollment enrollment) throws Exception {
        String sql = "INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.setDate(3, enrollment.getEnrollmentDate());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error adding enrollment", e);
        }
    }
    
    
    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses c JOIN enrollments e ON c.id = e.course_id WHERE e.student_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("id"));
                course.setCourseName(rs.getString("name"));
                // Set other course fields as needed
                courses.add(course);
            }
        } catch (Exception e) {
        }
        
        return courses;
    }

    // Retrieve enrollment by enrollment ID
    @Override
    public Enrollment getEnrollmentById(int enrollmentId) throws Exception {
        String sql = "SELECT * FROM Enrollments WHERE enrollment_id = ?";
        Enrollment enrollment = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    enrollment = new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving enrollment by ID", e);
        }

        return enrollment;
    }

    // Retrieve enrollments by student ID
    @Override
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception {
        String sql = "SELECT * FROM Enrollments WHERE student_id = ?";
        List<Enrollment> enrollmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Enrollment enrollment = new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date")
                    );
                    enrollmentList.add(enrollment);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving enrollments by student ID", e);
        }

        return enrollmentList;
    }

    // Retrieve enrollments by course ID
    @Override
    public List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception {
        String sql = "SELECT * FROM Enrollments WHERE course_id = ?";
        List<Enrollment> enrollmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Enrollment enrollment = new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date")
                    );
                    enrollmentList.add(enrollment);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving enrollments by course ID", e);
        }

        return enrollmentList;
    }

    // Retrieve all enrollments
    @Override
    public List<Enrollment> getAllEnrollments() throws Exception {
        String sql = "SELECT * FROM Enrollments ";
        List<Enrollment> enrollmentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                    rs.getInt("enrollment_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getDate("enrollment_date")
                );
                enrollmentList.add(enrollment);
            }

        } catch (SQLException e) {
            throw new Exception("Error retrieving all enrollments", e);
        }

        return enrollmentList;
    }

    // Update enrollment details
    @Override
    public void updateEnrollment(Enrollment enrollment) throws Exception {
        String sql = "UPDATE Enrollments SET student_id = ?, course_id = ?, enrollment_date = ? WHERE enrollment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.setDate(3, enrollment.getEnrollmentDate());
            stmt.setInt(4, enrollment.getEnrollmentId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error updating enrollment", e);
        }
    }

    // Delete enrollment by enrollment ID
    @Override
    public void deleteEnrollment(int enrollmentId) throws Exception {
        String sql = "DELETE FROM Enrollments WHERE enrollment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enrollmentId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error deleting enrollment", e);
        }
    }
}
