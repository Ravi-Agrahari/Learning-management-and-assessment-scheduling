
package TestPackages;

import Controllers.StudentController;


public class StudentMain {
    public static void main(String[] args){
        StudentController studentController = new StudentController() ; 
        studentController.manageStudents();
    }
}
