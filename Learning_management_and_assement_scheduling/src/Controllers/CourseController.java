package Controllers ;

import Models.Course;
import Services.CourseService;
import java.util.List;
import java.util.Scanner;

public class CourseController {
    private final CourseService courseService = new CourseService();
    private final Scanner scanner = new Scanner(System.in);

    public void manageCourses() {
        int choice;
        do {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. View Course By ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the leftover newline after nextInt()

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    viewCourseById();
                    break;
                case 0:
                    System.out.println("Exiting Course Management...");
                    return ;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addCourse() {
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();  // Read full line for course code
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();  // Read full line for course name
        System.out.print("Enter Syllabus: ");
        String syllabus = scanner.nextLine();  // Read full line for syllabus

        Course course = new Course(0, courseCode, courseName, syllabus);
        try {
            courseService.addCourse(course);
            System.out.println("Course added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    private void viewAllCourses() {
        try {
            List<Course> courses = courseService.getAllCourses();
            if (courses.isEmpty()) {
                System.out.println("No courses available.");
            } else {
                courses.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving courses: " + e.getMessage());
        }
    }

    private void updateCourse() {
        System.out.print("Enter Course ID to update: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        System.out.print("Enter New Course Code: ");
        String courseCode = scanner.nextLine();  // Read full line for course code
        System.out.print("Enter New Course Name: ");
        String courseName = scanner.nextLine();  // Read full line for course name
        System.out.print("Enter New Syllabus: ");
        String syllabus = scanner.nextLine();  // Read full line for syllabus

        Course course = new Course(courseId, courseCode, courseName, syllabus);
        try {
            courseService.updateCourse(course);
            System.out.println("Course updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating course: " + e.getMessage());
        }
    }

    private void deleteCourse() {
        System.out.print("Enter Course ID to delete: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        try {
            courseService.deleteCourse(courseId);
            System.out.println("Course deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting course: " + e.getMessage());
        }
    }

    private void viewCourseById() {
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after nextInt()

        try {
            Course course = courseService.getCourseById(courseId);
            if (course != null) {
                System.out.println(course);
            } else {
                System.out.println("Course not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving course: " + e.getMessage());
        }
    }
}

