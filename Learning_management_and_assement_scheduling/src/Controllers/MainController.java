package Controllers;

import Models.User;
import Services.UserService;

import java.util.Scanner;

public class MainController {

    private final UserController userController = new UserController();
    private final StudentController studentController = new StudentController();
    private final CourseController courseController = new CourseController();
    private final EnrollmentController enrollmentController = new EnrollmentController();
    private final MarksController marksController = new MarksController();
    private final AssessmentController assessmentController = new AssessmentController();
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws Exception {
        System.out.println("Welcome to the Learning Management System");
        login();
    }

    public void login() throws Exception {
        System.out.print("\nEnter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = userService.authenticate(username, password); // Check credentials with database

        if (user != null) {
            System.out.println("Login successful!");
            navigateToRoleMenu(user);
        } else {
            System.out.println("Invalid credentials. Please try again.");
            login(); // Retry login on failure
        }
    }

    private void navigateToRoleMenu(User user) throws Exception {
        switch (user.getRole().toLowerCase()) {
            case "admin":
                showAdminMenu();
                break;
            case "professor":
                showProfessorMenu();
                break;
            case "student":
                showStudentMenu();
                break;
            default:
                System.out.println("Unknown role. Please contact the system administrator.");
                logout();
                break;
        }
    }

    // Admin Menu
    private void showAdminMenu() throws Exception {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Enrollments");
            System.out.println("3. Manage Students");
            System.out.println("4. Manage Users");
            System.out.println("5. Logout");
            System.out.println("0. Exit the program");
            System.out.print("Select an option: ");
            int choice = getChoice();

            switch (choice) {
                case 1 -> courseController.manageCourses();
                case 2 -> enrollmentController.manageEnrollments();
                case 3 -> studentController.manageStudents();
                case 4 -> userController.manageUsers();
                case 5 -> logout();
                case 0 ->  {
                    System.out.println("Bye Bye !!! See you again ...");
                    return ;
                }
                
                
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Professor Menu
    private void showProfessorMenu() throws Exception {
        while (true) {
            System.out.println("\n===== Professor Menu =====");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Assessments");
            System.out.println("3. Manage Marks");
            System.out.println("4. Manage Students");
            System.out.println("5. Logout");
            System.out.println("0. Exit the program");
            System.out.print("Select an option: ");
            int choice = getChoice();

            switch (choice) {
                case 1 -> courseController.manageCourses();
                case 2 -> assessmentController.manageAssessments();
                case 3 -> marksController.manageMarks();
                case 4 -> studentController.manageStudents();
                case 5 -> logout();
                case 0 -> { 
                    System.out.println("Bye Bye !!! See you again ...");
                    return ; } 
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Student Menu
    private void showStudentMenu() throws Exception {
        
        System.out.println("\n===== Student Menu =====");
            
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter the student_id : ");
        int student_id = sc.nextInt() ;
        
        while (true) {
            
            System.out.println("\n1. View Enrolled Courses");
            System.out.println("2. View Marks");
            System.out.println("3. Logout");
            System.out.println("0. Exit the program");
            System.out.print("Select an option: ");
            int choice = getChoice();
            
             

            switch (choice) {
                case 1 -> enrollmentController.viewEnrolledCourses(student_id);
                case 2 -> marksController.viewStudentMarks(student_id);
                case 3 -> logout();
                case 0 -> { 
                    System.out.println("Bye Bye !!! See you again ...");
                    return ;
                } 
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear the invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }

    public void logout() throws Exception {
        System.out.println("Logging out...");
        login();
    }
}
