
package Services;

import DAO.CourseDAO;
import DAO.CourseDAOImpl;
import Models.Course;
import java.util.List;

public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAOImpl() ;
    }

    public void addCourse(Course course) throws Exception {
        courseDAO.addCourse(course);
    }

    public Course getCourseById(int courseId) throws Exception {
        return courseDAO.getCourseById(courseId);
    }

    public List<Course> getAllCourses() throws Exception {
        return courseDAO.getAllCourses();
    }

    public void updateCourse(Course course) throws Exception {
        courseDAO.updateCourse(course);
    }

    public void deleteCourse(int courseId) throws Exception {
        courseDAO.deleteCourse(courseId);
    }
}
