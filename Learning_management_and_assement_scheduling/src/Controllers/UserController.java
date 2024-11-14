
package Controllers;



import Services.UserService;
import Models.User;


import java.util.List;
import java.util.Scanner;

public class UserController {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageUsers() {
        int choice;
        do {
            System.out.println("\n--- User Management ---");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. View User By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    viewUserById();
                    break;
                case 0:
                    System.out.println("Exiting User Management...");
                    return ; 
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addUser() {
        System.out.print("Enter User Name: ");
        String userName = scanner.nextLine();  // Read full line for user name
        
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();  // Read full line for role
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();  // Read full line for password

        User user = new User(0, userName, password , role);
        try {
            userService.addUser(user);
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    private void viewAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if (users.isEmpty()) {
                System.out.println("No users available.");
            } else {
                users.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    private void updateUser() {
        System.out.print("Enter User ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        System.out.print("Enter New User Name: ");
        String userName = scanner.nextLine();  // Read full line for user name
       
        System.out.print("Enter New Role: ");
        String role = scanner.nextLine();  // Read full line for role
        System.out.print("Enter New Password: ");
        String password = scanner.nextLine();  // Read full line for password

        User user = new User(userId, userName, password , role);
        try {
            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    private void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        try {
            userService.deleteUser(userId);
            System.out.println("User deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    private void viewUserById() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        try {
            User user = userService.getUserById(userId);
            if (user != null) {
                System.out.println(user);
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
    }
}


