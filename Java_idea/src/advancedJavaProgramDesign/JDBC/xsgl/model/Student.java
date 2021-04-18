package advancedJavaProgramDesign.JDBC.xsgl.model;

import java.sql.Date;
import java.util.Arrays;

public class Student {
    private String StudNo;
    private Major major;
    private String studName;
    private String studSex;
    private String studAddress;
    private String studResume;
    private String studMember;
    private byte[] studPic;
    private Date studBirthDate;
    
    public String getStudNo() {
        return StudNo;
    }
    public void setStudNo(String studNo) {
        StudNo = studNo;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public String getStudName() {
        return studName;
    }
    public void setStudName(String studName) {
        this.studName = studName;
    }
    public String getStudSex() {
        return studSex;
    }
    public void setStudSex(String studSex) {
        this.studSex = studSex;
    }
    public String getStudAddress() {
        return studAddress;
    }
    public void setStudAddress(String studAddress) {
        this.studAddress = studAddress;
    }
    public String getStudResume() {
        return studResume;
    }
    public void setStudResume(String studResume) {
        this.studResume = studResume;
    }
    public String getStudMember() {
        return studMember;
    }
    public void setStudMember(String studMember) {
        this.studMember = studMember;
    }
    public byte[] getStudPic() {
        return studPic;
    }
    public void setStudPic(byte[] studPic) {
        this.studPic = studPic;
    }
    public Date getStudBirthDate() {
        return studBirthDate;
    }
    public void setStudBirthDate(Date studBirthDate) {
        this.studBirthDate = studBirthDate;
    }

    @Override
    public String toString() {
        return "Student [StudNo=" + StudNo + ", major=" + major + ", studAddress=" + studAddress + ", studBirthDate="
                + studBirthDate + ", studMember=" + studMember + ", studName=" + studName + ", studPic="
                + Arrays.toString(studPic) + ", studResume=" + studResume + ", studSex=" + studSex + "]";
    }

}
