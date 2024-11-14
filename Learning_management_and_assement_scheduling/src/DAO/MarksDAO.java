
package DAO;


import Models.Marks;
import java.util.List;

public interface MarksDAO {
    void addMarks(Marks marks) throws Exception;
    Marks getMarksById(int markId) throws Exception;
    List<Marks> getMarksByStudentId(int studentId) throws Exception;
    List<Marks> getAllMarks() throws Exception;
    void updateMarks(Marks marks) throws Exception;
    void deleteMarks(int markId) throws Exception;
    
}
