
package TestPackages;

import Controllers.CourseController;


public class CourseMain {
    public static void main(String[] args){
        CourseController courseController = new CourseController() ; 
        courseController.manageCourses();
    }
}

