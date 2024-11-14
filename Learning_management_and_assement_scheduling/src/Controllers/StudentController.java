package Controllers;

import Services.StudentService;
import Models.Student;
import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService studentService = new StudentService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageStudents() {
        int choice;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View Student By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    viewStudentById();
                    break;
                case 0:
                    System.out.println("Exiting Student Management...");
                    return ; 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addStudent() {
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Student student = new Student(0,name, rollNo, department);
        try {
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private void viewAllStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving all students: " + e.getMessage());
        }
    }

    private void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Roll No: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();

        Student student = new Student(studentId, name, rollNo, department);
        try {
            studentService.updateStudent(student);
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int studentId = scanner.nextInt();
        try {
            studentService.deleteStudent(studentId);
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    private void viewStudentById() {
        System.out.print("Enter Student ID to view: ");
        int studentId = scanner.nextInt();
        try {
            Student student = studentService.getStudentById(studentId);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving student by ID: " + e.getMessage());
        }
    }
}
