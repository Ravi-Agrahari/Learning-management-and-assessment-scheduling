package DAO;

import Models.Course;
import Models.Enrollment;
import java.util.List;

public interface EnrollmentDAO {
    void addEnrollment(Enrollment enrollment) throws Exception;
    Enrollment getEnrollmentById(int enrollmentId) throws Exception;
    List<Enrollment> getEnrollmentsByStudentId(int studentId) throws Exception;
    List<Enrollment> getEnrollmentsByCourseId(int courseId) throws Exception;
    List<Enrollment> getAllEnrollments() throws Exception;
    void updateEnrollment(Enrollment enrollment) throws Exception;
    void deleteEnrollment(int enrollmentId) throws Exception;
    List<Course> getCoursesByStudentId(int studentId);
}
