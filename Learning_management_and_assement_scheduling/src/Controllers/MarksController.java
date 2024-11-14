package Controllers;

import Services.MarksService;
import Models.Marks;
import Services.AssessmentService;
import java.util.List;
import java.util.Scanner;

public class MarksController {

    private final MarksService marksService = new MarksService();
    private final AssessmentService assessmentService = new AssessmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageMarks() {
        int choice;
        do {
            System.out.println("\n--- Marks Management ---");
            System.out.println("1. Add Marks");
            System.out.println("2. View All Marks");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Marks");
            System.out.println("5. View Marks By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addMarks();
                    break;
                case 2:
                    viewAllMarks();
                    break;
                case 3:
                    updateMarks();
                    break;
                case 4:
                    deleteMarks();
                    break;
                case 5:
                    viewMarksById();
                    break;
                case 0:
                    System.out.println("Exiting Marks Management...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    public void viewStudentMarks(int studentId) throws Exception {
        List<Marks> marks = marksService.viewStudentMarks(studentId);

        if (marks.isEmpty()) {
            System.out.println("No marks found for the student.");
        } else {
            System.out.println("Student Marks:");
            for (Marks mark : marks) {
                System.out.println(
                        "Assessment Title: " + assessmentService.getAssessmentById(mark.getAssessmentId()).getAssessmentType()
                        + ", Mark Obtained: " + mark.getMarksObtained());
            }
        }
    }

    private void addMarks() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Assessment ID: ");
        int assessmentId = scanner.nextInt();
        System.out.print("Enter Marks Obtained: ");
        int marksObtained = scanner.nextInt();
        System.out.print("Enter Max Marks: ");
        int maxMarks = scanner.nextInt();

        Marks marks = new Marks(0, studentId, assessmentId, marksObtained, maxMarks);
        try {
            marksService.addMarks(marks);
            System.out.println("Marks added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding marks: " + e.getMessage());
        }
    }

    private void viewAllMarks() {
        try {
            List<Marks> marksList = marksService.getAllMarks();
            if (marksList.isEmpty()) {
                System.out.println("No marks available.");
            } else {
                marksList.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving marks: " + e.getMessage());
        }
    }

    private void updateMarks() {
        System.out.print("Enter Marks ID to update: ");
        int markId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        System.out.print("Enter New Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter New Assessment ID: ");
        int assessmentId = scanner.nextInt();
        System.out.print("Enter New Marks Obtained: ");
        int marksObtained = scanner.nextInt();
        System.out.print("Enter New Max Marks: ");
        int maxMarks = scanner.nextInt();

        Marks marks = new Marks(markId, studentId, assessmentId, marksObtained, maxMarks);
        try {
            marksService.updateMarks(marks);
            System.out.println("Marks updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating marks: " + e.getMessage());
        }
    }

    private void deleteMarks() {
        System.out.print("Enter Marks ID to delete: ");
        int markId = scanner.nextInt();
        try {
            marksService.deleteMarks(markId);
            System.out.println("Marks deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting marks: " + e.getMessage());
        }
    }

    private void viewMarksById() {
        System.out.print("Enter Marks ID to view: ");
        int markId = scanner.nextInt();
        try {
            Marks marks = marksService.getMarksById(markId);
            if (marks != null) {
                System.out.println(marks);
            } else {
                System.out.println("Marks not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving marks by ID: " + e.getMessage());
        }
    }
}
