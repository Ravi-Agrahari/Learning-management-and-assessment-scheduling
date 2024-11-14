package Controllers;

import Models.Course;
import Services.EnrollmentService;
import Models.Enrollment;
import Services.MarksService;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EnrollmentController {
    private final EnrollmentService enrollmentService = new EnrollmentService();
    private final MarksService marksService = new MarksService() ; 
    private final Scanner scanner = new Scanner(System.in);

    public void manageEnrollments() {
        int choice;
        do {
            System.out.println("\n--- Enrollment Management ---");
            System.out.println("1. Add Enrollment");
            System.out.println("2. View All Enrollments");
            System.out.println("3. Update Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. View Enrollment By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addEnrollment();
                    break;
                case 2:
                    viewAllEnrollments();
                    break;
                case 3:
                    updateEnrollment();
                    break;
                case 4:
                    deleteEnrollment();
                    break;
                case 5:
                    viewEnrollmentById();
                    break;
                case 0:
                    System.out.println("Exiting Enrollment Management...");
                    return ; 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
    
    
    public void viewEnrolledCourses(int studentId) {
        List<Course> courses = enrollmentService.viewEnrolledCourses(studentId);
        
        if (courses.isEmpty()) {
            System.out.println("No courses found for the student.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course course : courses) {
                System.out.println(" - " + course.getCourseName());
            }
        }
    }
    
    
   
    private void addEnrollment() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter Enrollment Date (yyyy-mm-dd): ");
        String date = scanner.next();

        Enrollment enrollment = new Enrollment(0, studentId, courseId, Date.valueOf(date));
        try {
            enrollmentService.addEnrollment(enrollment);
            System.out.println("Enrollment added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding enrollment: " + e.getMessage());
        }
    }

    private void viewAllEnrollments() {
        try {
            List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found.");
            } else {
                for (Enrollment enrollment : enrollments) {
                    System.out.println(enrollment);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving all enrollments: " + e.getMessage());
        }
    }

    private void updateEnrollment() {
        System.out.print("Enter Enrollment ID to update: ");
        int enrollmentId = scanner.nextInt();
        System.out.print("Enter New Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter New Course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter New Enrollment Date (yyyy-mm-dd): ");
        String date = scanner.next();

        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, Date.valueOf(date));
        try {
            enrollmentService.updateEnrollment(enrollment);
            System.out.println("Enrollment updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating enrollment: " + e.getMessage());
        }
    }

    private void deleteEnrollment() {
        System.out.print("Enter Enrollment ID to delete: ");
        int enrollmentId = scanner.nextInt();
        try {
            enrollmentService.deleteEnrollment(enrollmentId);
            System.out.println("Enrollment deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting enrollment: " + e.getMessage());
        }
    }

    private void viewEnrollmentById() {
        System.out.print("Enter Enrollment ID to view: ");
        int enrollmentId = scanner.nextInt();
        try {
            Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
            if (enrollment != null) {
                System.out.println(enrollment);
            } else {
                System.out.println("Enrollment not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving enrollment by ID: " + e.getMessage());
        }
    }
}
