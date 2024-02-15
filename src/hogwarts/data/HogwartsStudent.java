package hogwarts.data;

import generic.Student;

import java.util.Arrays;

public class HogwartsStudent extends Student implements HogwartsPerson{
    private House house;
    private boolean prefect;
    private String[] teams;

    private String role = "Student";

    public HogwartsStudent() {}

    public HogwartsStudent(House house, boolean prefect, String[] teams) {
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(String fullName, int age, House house, boolean prefect) {
        super(fullName, age);
        this.house = house;
        this.prefect = prefect;
        this.setAge(age);
    }


    public HogwartsStudent(String fullName) {
        super(fullName);
    }

    public House getHouse() {
        return house;
    }
    public void setHouse(House house) {
        this.house = house;
    }

    public boolean getPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "HogwartsStudent{" +
                "house=" + house +
                ", prefect=" + prefect +
                ", teams=" + Arrays.toString(teams) +
                '}';
    }

    @Override
    public int compareTo(HogwartsPerson o) {
        return 0;
    }
}
