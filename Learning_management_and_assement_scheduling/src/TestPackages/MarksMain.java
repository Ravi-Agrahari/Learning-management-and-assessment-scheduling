
package TestPackages;

import Controllers.MarksController;


public class MarksMain {
    public static void main(String[] args){
        MarksController marksController = new MarksController() ; 
        marksController.manageMarks();
    }
}