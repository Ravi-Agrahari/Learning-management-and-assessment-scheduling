package Models ;

import java.sql.Date;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private Date enrollmentDate;

    // Constructors
    public Enrollment() {}

    public Enrollment(int enrollmentId, int studentId, int courseId, Date enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public int getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(int enrollmentId) { this.enrollmentId = enrollmentId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    @Override
    public String toString() {
        return "Enrollment{enrollmentId=" + enrollmentId + ", studentId=" + studentId + ", courseId=" + courseId + ", enrollmentDate=" + enrollmentDate + "}";
    }
}

