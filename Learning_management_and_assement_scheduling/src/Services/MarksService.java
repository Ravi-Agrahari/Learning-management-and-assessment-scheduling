package Services;

import DAO.MarksDAO;
import DAO.MarksDAOImpl;
import Models.Marks;
import java.util.List;

public class MarksService {

    private final MarksDAO marksDAO;

    public MarksService() {
        this.marksDAO = new MarksDAOImpl();
    }

    public void addMarks(Marks marks) throws Exception {
        marksDAO.addMarks(marks);
    }

    public Marks getMarksById(int markId) throws Exception {
        return marksDAO.getMarksById(markId);
    }

    public List<Marks> getMarksByStudentId(int studentId) throws Exception {
        return marksDAO.getMarksByStudentId(studentId);
    }

    public List<Marks> getAllMarks() throws Exception {
        return marksDAO.getAllMarks();
    }

    public void updateMarks(Marks marks) throws Exception {
        marksDAO.updateMarks(marks);
    }

    public void deleteMarks(int markId) throws Exception {
        marksDAO.deleteMarks(markId);
    }
    
    
    public List<Marks> viewStudentMarks(int studentId) throws Exception {
        return marksDAO.getMarksByStudentId(studentId);
    }
}
