package Models; 

public class Marks {
    private int markId;
    private int studentId;
    private int assessmentId;
    private int marksObtained;
    private int maxMarks;

    // Constructors
    public Marks() {}

    public Marks(int markId, int studentId, int assessmentId, int marksObtained, int maxMarks) {
        this.markId = markId;
        this.studentId = studentId;
        this.assessmentId = assessmentId;
        this.marksObtained = marksObtained;
        this.maxMarks = maxMarks;
    }

    // Getters and Setters
    public int getMarkId() { return markId; }
    public void setMarkId(int markId) { this.markId = markId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getAssessmentId() { return assessmentId; }
    public void setAssessmentId(int assessmentId) { this.assessmentId = assessmentId; }

    public int getMarksObtained() { return marksObtained; }
    public void setMarksObtained(int marksObtained) { this.marksObtained = marksObtained; }

    public int getMaxMarks() { return maxMarks; }
    public void setMaxMarks(int maxMarks) { this.maxMarks = maxMarks; }

    @Override
    public String toString() {
        return "Marks{markId=" + markId + ", studentId=" + studentId + ", assessmentId=" + assessmentId + ", marksObtained=" + marksObtained + ", maxMarks=" + maxMarks + "}";
    }
}

