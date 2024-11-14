package DAO;

import Models.Student;
import java.util.List;

public interface StudentDAO {
    void addStudent(Student student) throws Exception;
    Student getStudentById(int studentId) throws Exception;
    List<Student> getAllStudents() throws Exception;
    void updateStudent(Student student) throws Exception;
    void deleteStudent(int studentId) throws Exception;
}
