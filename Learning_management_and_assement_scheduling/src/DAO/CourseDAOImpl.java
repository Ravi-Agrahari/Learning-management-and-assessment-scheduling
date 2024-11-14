
package DAO;

import Models.Course;
import Utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    // Add a new course
    @Override
    public void addCourse(Course course) throws Exception {
        String sql = "INSERT INTO Courses (course_code, course_name, syllabus) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getSyllabus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error adding course", e);
        }
    }

    // Retrieve course by ID
    @Override
    public Course getCourseById(int courseId) throws Exception {
        String sql = "SELECT * FROM Courses WHERE course_id = ?";
        Course course = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        rs.getString("syllabus")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving course by ID", e);
        }

        return course;
    }

    // Retrieve all courses
    @Override
    public List<Course> getAllCourses() throws Exception {
        String sql = "SELECT * FROM Courses";
        List<Course> courses = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_code"),
                    rs.getString("course_name"),
                    rs.getString("syllabus")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error retrieving all courses", e);
        }

        return courses;
    }

    // Update course details
    @Override
    public void updateCourse(Course course) throws Exception {
        String sql = "UPDATE Courses SET course_code = ?, course_name = ?, syllabus = ? WHERE course_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getSyllabus());
            stmt.setInt(4, course.getCourseId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error updating course", e);
        }
    }

    // Delete course by ID
    @Override
    public void deleteCourse(int courseId) throws Exception {
        String sql = "DELETE FROM Courses WHERE course_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, courseId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error deleting course", e);
        }
    }
}

