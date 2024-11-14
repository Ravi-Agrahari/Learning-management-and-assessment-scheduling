
package DAO;

import Models.Course;
import java.util.List;

public interface CourseDAO {
    void addCourse(Course course) throws Exception;
    Course getCourseById(int courseId) throws Exception;
    List<Course> getAllCourses() throws Exception;
    void updateCourse(Course course) throws Exception;
    void deleteCourse(int courseId) throws Exception;
}
