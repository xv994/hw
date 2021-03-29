package advancedJavaProgramDesign.JDBC.xsgl.idao;

import java.util.List;
import advancedJavaProgramDesign.JDBC.xsgl.model.Student;

public interface IStudentDao {
   boolean addStudent(Student student);
   boolean deleteStudent(String studNo);
   boolean editStudent(Student student);
   int findCount(String studName);
   Student findStudent(String studNo);
   List<Student> findStudents(String studName,Integer pageNo,Integer pageSize);
}
