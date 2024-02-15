package hogwarts.data;
import java.util.Comparator;
public class HogwartsPersonComparator implements Comparator<HogwartsPerson> {
    private HogwartsPersonSortBy sortBy;

    public HogwartsPersonComparator(HogwartsPersonSortBy sortBy) {
        this.sortBy = sortBy;
    }

    public int compare(HogwartsPerson p1, HogwartsPerson p2) {
        switch (sortBy) {
            case FIRST_NAME -> {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
            case MIDDLE_NAME -> {
                return p1.getMiddleName().compareTo(p2.getMiddleName());
            }
            case LAST_NAME -> {
                return p1.getLastName().compareTo(p2.getLastName());
            }
            case AGE -> {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
            case HOUSE -> {
                return p1.getHouse().getName().compareTo(p2.getHouse().getName());
            }
            default -> System.out.println("Invalid argument for comparison");
        }
        return 0;
    }
}