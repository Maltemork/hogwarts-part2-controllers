package generic;

import generic.Person;
import hogwarts.data.*;

import java.util.Date;

public class Teacher extends Person {
    //Fields
    private String employmentType;
    private Date employmentStart;
    private Date employmentEnd;




    //Getters and setters
    public Date getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(Date employmentStart) {
        this.employmentStart = employmentStart;
    }

    public Date getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(Date employmentEnd) {
        this.employmentEnd = employmentEnd;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    //Constructors
    public Teacher(String fullName, int age){
        super(fullName, age);
    }

    public Teacher(String fullName) {
        super(fullName);
    }

    public Teacher(String empType, Date employmentStart, Date employmentEnd) {
        this.employmentType = empType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String fullName, int age, String empType, Date employmentStart, Date employmentEnd) {
        super(fullName, age);
        this.employmentType = empType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String firstName, String lastName, String empType, Date employmentStart, Date employmentEnd) {
        super(firstName, lastName);
        this.employmentType = empType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String firstName, String middleName, String lastName, String empType, Date employmentStart, Date employmentEnd) {
        super(firstName, middleName, lastName);
        this.employmentType = empType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public Teacher(String fullName, String empType, Date employmentStart, Date employmentEnd) {
        super(fullName);
    }

    //toString
    @Override
    public String toString() {
        return "Teacher{" +
                "empType='" + employmentType + '\'' +
                ", employmentStart=" + employmentStart +
                ", employmentEnd=" + employmentEnd +
                '}';
    }
}
