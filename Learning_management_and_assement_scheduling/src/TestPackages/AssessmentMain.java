
package TestPackages;

import Controllers.AssessmentController;


public class AssessmentMain {
    public static void main(String[] args){
        AssessmentController assessmentController = new AssessmentController() ; 
        assessmentController.manageAssessments();
    }
}
