
package TestPackages;

import Controllers.EnrollmentController;


public class EnrollmentMain {
    public static void main(String[] args){
        EnrollmentController enrollmentController = new EnrollmentController() ; 
        enrollmentController.manageEnrollments();
    }
}
