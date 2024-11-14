package Controllers;

import Services.AssessmentService;
import Models.Assessment;
import java.sql.Date;
import java.sql.Time ;
import java.util.List;
import java.util.Scanner;

public class AssessmentController {
    private final AssessmentService assessmentService = new AssessmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageAssessments() {
        int choice;
        do {
            System.out.println("\n--- Assessment Management ---");
            System.out.println("1. Add Assessment");
            System.out.println("2. View All Assessments");
            System.out.println("3. Update Assessment");
            System.out.println("4. Delete Assessment");
            System.out.println("5. View Assessment By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addAssessment();
                    break;
                case 2:
                    viewAllAssessments();
                    break;
                case 3:
                    updateAssessment();
                    break;
                case 4:
                    deleteAssessment();
                    break;
                case 5:
                    viewAssessmentById();
                    break;
                case 0:
                    System.out.println("Exiting Assessment Management...");
                    return ; 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addAssessment() {
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter Assessment Type: ");
        String assessmentType = scanner.nextLine();
        System.out.print("Enter Scheduled Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter Scheduled Time (hh:mm:ss): ");
        String time = scanner.nextLine();

        Assessment assessment = new Assessment(0, courseId, assessmentType, Date.valueOf(date), Time.valueOf(time));
        try {
            assessmentService.addAssessment(assessment);
            System.out.println("Assessment added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding assessment: " + e.getMessage());
        }
    }

    private void viewAllAssessments() {
        try {
            List<Assessment> assessments = assessmentService.getAllAssessments();
            if (assessments.isEmpty()) {
                System.out.println("No assessments available.");
            } else {
                assessments.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving assessments: " + e.getMessage());
        }
    }

    private void updateAssessment() {
        System.out.print("Enter Assessment ID to update: ");
        int assessmentId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.print("Enter New Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter New Assessment Type: ");
        String assessmentType = scanner.nextLine();
        System.out.print("Enter New Scheduled Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter New Scheduled Time (hh:mm:ss): ");
        String time = scanner.nextLine();

        Assessment assessment = new Assessment(assessmentId, courseId, assessmentType, Date.valueOf(date), Time.valueOf(time));
        try {
            assessmentService.updateAssessment(assessment);
            System.out.println("Assessment updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating assessment: " + e.getMessage());
        }
    }

    private void deleteAssessment() {
        System.out.print("Enter Assessment ID to delete: ");
        int assessmentId = scanner.nextInt();
        try {
            assessmentService.deleteAssessment(assessmentId);
            System.out.println("Assessment deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting assessment: " + e.getMessage());
        }
    }

    private void viewAssessmentById() {
        System.out.print("Enter Assessment ID to view: ");
        int assessmentId = scanner.nextInt();
        try {
            Assessment assessment = assessmentService.getAssessmentById(assessmentId);
            if (assessment != null) {
                System.out.println(assessment);
            } else {
                System.out.println("Assessment not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving assessment by ID: " + e.getMessage());
        }
    }
}
