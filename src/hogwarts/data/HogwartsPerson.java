package hogwarts.data;

public interface HogwartsPerson extends Comparable<HogwartsPerson> { ;
    String getFirstName();
    String getMiddleName();
    String getLastName();
    int getAge();
    House getHouse();

    Object getRole();
}
