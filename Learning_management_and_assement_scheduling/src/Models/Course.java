package Models ;


public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private String syllabus;

    // Constructors
    public Course() {}

    public Course(int courseId, String courseCode, String courseName, String syllabus) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.syllabus = syllabus;
    }

    // Getters and Setters
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getSyllabus() { return syllabus; }
    public void setSyllabus(String syllabus) { this.syllabus = syllabus; }

    @Override
    public String toString() {
        return "Course{courseId=" + courseId + ", courseCode='" + courseCode + "', courseName='" + courseName + "'}";
    }
}
