package Services;

import DAO.EnrollmentDAO;
import DAO.EnrollmentDAOImpl;
import Models.Course;
import Models.Enrollment;
import java.util.List;

public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO;

    public EnrollmentService() {
        this.enrollmentDAO = new EnrollmentDAOImpl();
    }

    public void addEnrollment(Enrollment enrollment) throws Exception {
        enrollmentDAO.addEnrollment(enrollment);
    }

    public Enrollment getEnrollmentById(int enrollmentId) throws Exception {
        return enrollmentDAO.getEnrollmentById(enrollmentId);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception {
        return enrollmentDAO.getEnrollmentsByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception {
        return enrollmentDAO.getEnrollmentsByCourseId(courseId);
    }

    public List<Enrollment> getAllEnrollments() throws Exception {
        return enrollmentDAO.getAllEnrollments();
    }

    public void updateEnrollment(Enrollment enrollment) throws Exception {
        enrollmentDAO.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(int enrollmentId) throws Exception {
        enrollmentDAO.deleteEnrollment(enrollmentId);
    }
    
    public List<Course> viewEnrolledCourses(int studentId) {
        return enrollmentDAO.getCoursesByStudentId(studentId);
    }
}
