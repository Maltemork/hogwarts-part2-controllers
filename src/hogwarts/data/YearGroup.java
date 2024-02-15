package hogwarts.data;

import generic.Student;

import java.util.Date;

public class YearGroup {
    private int schoolYear;
    private Date beginningOfSchoolYear;
    private Student[] students;

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Student[] students) {
        this.students = students;
    }

    public Date getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(Date beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
