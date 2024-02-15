package hogwarts.data;

import generic.Teacher;

import java.util.Date;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {
    private House house;
    private boolean headOfHouse;

    private final String role = "Teacher";

    //Getters & Setters
    @Override
    public House getHouse() {
        return house;
    }

    public String getRole() { return role; }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }
    //Constructors
    public HogwartsTeacher(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(HogwartsPerson o) {
        return 0;
    }

    //Constructors
    public HogwartsTeacher(String fullName, int age){
        super(fullName, age);
    }

    public HogwartsTeacher(String fullName, int age, House house, boolean headOfHouse){
        super(fullName, age);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher(String empType, Date employmentStart, Date employmentEnd, House house, boolean headOfHouse) {
        super(empType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher(String fullName, String empType, Date employmentStart, Date employmentEnd, House house, boolean headOfHouse) {
        super(fullName, empType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher(String firstName, String lastName, String empType, Date employmentStart, Date employmentEnd, House house, boolean headOfHouse) {
        super(firstName, lastName, empType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher(String firstName, String middleName, String lastName, String empType, Date employmentStart, Date employmentEnd, House house, boolean headOfHouse) {
        super(firstName, middleName, lastName, empType, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

}
