package Services;

import DAO.AssessmentDAO;
import DAO.AssessmentDAOImpl;
import Models.Assessment;
import java.util.List;

public class AssessmentService {

    private final AssessmentDAO assessmentDAO;

    public AssessmentService() {
        this.assessmentDAO = new AssessmentDAOImpl();
    }

    public void addAssessment(Assessment assessment) throws Exception {
        assessmentDAO.addAssessment(assessment);
    }

    public Assessment getAssessmentById(int assessmentId) throws Exception {
        return assessmentDAO.getAssessmentById(assessmentId);
    }

    public List<Assessment> getAssessmentsByCourseId(int courseId) throws Exception {
        return assessmentDAO.getAssessmentsByCourseId(courseId);
    }

    public List<Assessment> getAllAssessments() throws Exception {
        return assessmentDAO.getAllAssessments();
    }

    public void updateAssessment(Assessment assessment) throws Exception {
        assessmentDAO.updateAssessment(assessment);
    }

    public void deleteAssessment(int assessmentId) throws Exception {
        assessmentDAO.deleteAssessment(assessmentId);
    }
}
