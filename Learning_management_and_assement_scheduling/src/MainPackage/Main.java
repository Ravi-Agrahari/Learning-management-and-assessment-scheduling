package MainPackage ; 

import Controllers.MainController;



public class Main {

    public static void main(String[] args) throws Exception {
        // Start the application
        MainController mainController = new MainController() ; 
        mainController.login();
    }
 
}
