package DAO;

import Models.Assessment;
import java.util.List;

public interface AssessmentDAO {
    void addAssessment(Assessment assessment) throws Exception;
    Assessment getAssessmentById(int assessmentId) throws Exception;
    List<Assessment> getAssessmentsByCourseId(int courseId) throws Exception;
    List<Assessment> getAllAssessments() throws Exception;
    void updateAssessment(Assessment assessment) throws Exception;
    void deleteAssessment(int assessmentId) throws Exception;
}

