
package TestPackages;

import Controllers.UserController;


public class UserMain {
    public static void main(String[] args){
        UserController userController = new UserController() ; 
        userController.manageUsers();
    }
}
