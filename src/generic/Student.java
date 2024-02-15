package generic;

import hogwarts.data.House;
import generic.Person;

public class Student extends Person {
  private int enrollmentYear;
  private int graduationYear;
  private boolean graduated;

  public Student() {}

  public Student(String fullName, int age) {
    super(fullName, age);
  }

  public Student(
          String firstName,
          String middleName,
          String lastName,
          int graduationYear,
          boolean graduated,
          int enrollmentYear
  ) {
    super(firstName, lastName, middleName);
  }

  public Student(String fullName) {
    super(fullName);
  }


  // Getters and setters
  public int getEnrollmentYear() {
    return enrollmentYear;
  }

  public void setEnrollmentYear(int enrollmentYear) {
    this.enrollmentYear = enrollmentYear;
  }

  public int getGraduationYear() {
    return graduationYear;
  }

  public void setGraduationYear(int graduationYear) {
    this.graduationYear = graduationYear;
  }

  public boolean isGraduated() {
    return graduated;
  }

  public void setGraduated(boolean graduated) {
    this.graduated = graduated;
  }

  @Override
  public String toString() {
    return "Student{" +
            "graduationYear=" + graduationYear +
            ", graduated=" + graduated +
            ", enrollmentYear=" + enrollmentYear +
            '}';
  }
}
