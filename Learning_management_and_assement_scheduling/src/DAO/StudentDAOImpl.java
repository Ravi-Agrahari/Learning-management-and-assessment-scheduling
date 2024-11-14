package DAO;

import Models.Student;
import Utilities.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    // Add new student to the database
    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO Students (name, roll_no, department) VALUES ( ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getRollNo());
            stmt.setString(3, student.getDepartment());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error adding student", e);
        }
    }

    // Retrieve student by student ID
    @Override
    public Student getStudentById(int studentId) throws Exception {
        String sql = "SELECT * FROM Student WHERE student_id = ?";
        Student student = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("roll_no"),
                        rs.getString("department")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving student by ID", e);
        }

        return student;
    }

    // Retrieve all students
    @Override
    public List<Student> getAllStudents() throws Exception {
        String sql = "SELECT * FROM Students ";
        List<Student> studentList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("roll_no"),
                    rs.getString("department")
                );
                studentList.add(student);
            }

        } catch (SQLException e) {
            throw new Exception("Error retrieving all students", e);
        }

        return studentList;
    }

    // Update student details
    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE Students SET name = ?, roll_no = ?, department = ? WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getRollNo());
            stmt.setString(3, student.getDepartment());
            stmt.setInt(4, student.getStudentId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error updating student", e);
        }
    }

    // Delete student by student ID
    @Override
    public void deleteStudent(int studentId) throws Exception {
        String sql = "DELETE FROM Students WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error deleting student", e);
        }
    }
}
