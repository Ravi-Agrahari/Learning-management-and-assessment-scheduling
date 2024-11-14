package Services;

import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import Models.Student;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
    }

    public void addStudent(Student student) throws Exception {
        studentDAO.addStudent(student);
    }

    public Student getStudentById(int studentId) throws Exception {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }

    public void updateStudent(Student student) throws Exception {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) throws Exception {
        studentDAO.deleteStudent(studentId);
    }
}

