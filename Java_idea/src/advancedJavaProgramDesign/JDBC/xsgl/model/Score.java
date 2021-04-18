package advancedJavaProgramDesign.JDBC.xsgl.model;

public class Score {
    private Student student;
    private Course course;
    private Float score; 
    private  static Float avgScore;
    
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Float getScore() {
        return score;
    }
    public void setScore(Float score) {
        this.score = score;
    }
    public static Float getAvgScore() {
        return avgScore;
    }
    public static void setAvgScore(Float avgScore) {
        Score.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Score [course=" + course + ", score=" + score + ", student=" + student + "]";
    }
}
