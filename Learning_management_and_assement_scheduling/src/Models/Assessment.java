
package Models ;

import java.sql.Date;
import java.sql.Time;

public class Assessment {
    private int assessmentId;
    private int courseId;
    private String assessmentType;
    private Date scheduledDate;
    private Time scheduledTime;

    // Constructors
    public Assessment() {}

    public Assessment(int assessmentId, int courseId, String assessmentType, Date scheduledDate, Time scheduledTime) {
        this.assessmentId = assessmentId;
        this.courseId = courseId;
        this.assessmentType = assessmentType;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
    }

    // Getters and Setters
    public int getAssessmentId() { return assessmentId; }
    public void setAssessmentId(int assessmentId) { this.assessmentId = assessmentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getAssessmentType() { return assessmentType; }
    public void setAssessmentType(String assessmentType) { this.assessmentType = assessmentType; }

    public Date getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(Date scheduledDate) { this.scheduledDate = scheduledDate; }

    public Time getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(Time scheduledTime) { this.scheduledTime = scheduledTime; }

    @Override
    public String toString() {
        return "Assessment{assessmentId=" + assessmentId + ", courseId=" + courseId + ", assessmentType='" + assessmentType + "', scheduledDate=" + scheduledDate + ", scheduledTime=" + scheduledTime + "}";
    }
}
