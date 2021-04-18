package advancedJavaProgramDesign.JDBC.xsgl.model;

public class Course {
    private Integer courseNo;
    private String courseName;
    private String courseTeacher;
    
    public Integer getCourseNo() {
        return courseNo;
    }
    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseTeacher() {
        return courseTeacher;
    }
    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return "Course [courseName=" + courseName + ", courseNo=" + courseNo + ", courseTeacher=" + courseTeacher + "]";
    } 
}
