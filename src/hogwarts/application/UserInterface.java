package hogwarts.application;

import hogwarts.data.HogwartsPerson;
import hogwarts.data.HogwartsPersonComparator;
import hogwarts.data.HogwartsPersonSortBy;
import hogwarts.data.House;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class UserInterface {
    private StudentController studentController;
    private TeacherController teacherController;
    private List<HogwartsPerson> allPersons;

    public UserInterface(@NotNull StudentController studentController, @NotNull TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void start() {
        setAllPersons();
        System.out.println("----------Welcome to the Hogwarts Database----------");
        userInput();
    }

    public void setAllPersons() {
        allPersons = new ArrayList<>();
        allPersons.addAll(studentController.getAllStudents());
        allPersons.addAll(teacherController.getAllTeachers());
    }

    public void showData(List<HogwartsPerson> persons) {
        System.out.println("|-------------------------------------------------|---------------------------------------|");
        System.out.printf("| %-15s %-15s %-15s | %-5s %-15s %-15s |\n",
                "First Name", "Middle Name", "Last Name", "Age", "House", "Role"
        );
        System.out.println("|-------------------------------------------------|---------------------------------------|");
        //Only works if teachers list is smaller than students
        for (HogwartsPerson person : persons) {
            if (person.getHouse() == null) {
                System.out.printf("| %-15s %-15s %-15s | %-5d %-15s %-15s |\n",
                        person.getFirstName(), person.getMiddleName(), person.getLastName(), person.getAge(), "", person.getRole()
                );
            } else {
                System.out.printf(
                        "| %-15s %-15s %-15s | %-5d %-15s %-15s |\n",
                        person.getFirstName(), person.getMiddleName(), person.getLastName(), person.getAge(), person.getHouse().getName(), person.getRole()
                );
            }

        }
        System.out.println("|-------------------------------------------------|---------------------------------------|");
    }

    private void userInput() {
        System.out.flush();
        Scanner scanner = new Scanner(System.in);

        // Start message
        System.out.println("Type 'a' to view all.");
        System.out.println("Type 's' to sort.");
        System.out.println("Type 'f' to filter.");
        System.out.println("Type 'e' to exit.");

        // Input from user
        String input = scanner.nextLine();

        switch (input) {
            case "a" -> {
                System.out.flush();
                System.out.println("Showing all people in the database.");
                showData(allPersons);
                userInput();
            }
            case "s" -> {
                System.out.flush();
                System.out.println("Choose sorting by typing one of the following numbers:");
                System.out.println("1 - First name.");
                System.out.println("2 - Middle name.");
                System.out.println("3 - Last name.");
                System.out.println("4 - Age.");
                System.out.println("5 - House.");

                switch(scanner.nextInt()) {
                    case 1 -> allPersons.sort(new HogwartsPersonComparator(HogwartsPersonSortBy.FIRST_NAME));
                    case 2 -> allPersons.sort(new HogwartsPersonComparator(HogwartsPersonSortBy.MIDDLE_NAME));
                    case 3 -> allPersons.sort(new HogwartsPersonComparator(HogwartsPersonSortBy.LAST_NAME));
                    case 4 -> allPersons.sort(new HogwartsPersonComparator(HogwartsPersonSortBy.AGE));
                    case 5 -> allPersons.sort(new HogwartsPersonComparator(HogwartsPersonSortBy.HOUSE));
                    default -> System.out.println("Invalid input");
                }
                showData(allPersons);
                userInput();
            }
            case "f" -> {
                System.out.flush();
                System.out.println("Choose filter:");
                System.out.println("1. House");
                System.out.println("2. Role");
                switch(scanner.nextInt()) {
                    case 1 -> {
                        System.out.flush();
                        System.out.println("Choose house to sort by:");
                        System.out.println("1. Gryffindor");
                        System.out.println("2. Hufflepuff");
                        System.out.println("3. Ravenclaw");
                        System.out.println("4. Slytherin");
                        switch(scanner.nextInt()) {
                            case 1 -> {
                                System.out.println("Showing all people in the 'Gryffindor' house.");
                                showData(filteredList(allPersons, "Gryffindor", "H", ""));
                                userInput();
                            }
                            case 2 -> {
                                System.out.println("Showing all people in the 'Hufflepuff' house.");
                                showData(filteredList(allPersons, "Hufflepuff", "H", ""));
                                userInput();
                            }
                            case 3 -> {
                                System.out.println("Showing all people in the 'Ravenclaw' house.");
                                showData(filteredList(allPersons, "Ravenclaw", "H", ""));
                                userInput();
                            }
                            case 4 -> {
                                System.out.println("Showing all people in the 'Slytherin' house.");
                                showData(filteredList(allPersons, "Slytherin", "H", ""));
                                userInput();
                            }
                            default -> {
                                System.out.println("Invalid input");
                                userInput();
                            }
                        }
                    }
                    case 2 -> {
                        System.out.flush();
                        System.out.println("Choose role to filter by:");
                        System.out.println("1. Student.");
                        System.out.println("2. Teacher.");
                        switch(scanner.nextInt()) {
                            case 1 -> {
                                System.out.println("Showing all students.");
                                showData(filteredList(allPersons, "", "R", "Student"));
                                userInput();
                            }
                            case 2 -> {
                                System.out.println("Showing all teachers.");
                                showData(filteredList(allPersons, "", "R", "Teacher"));
                                userInput();
                            }
                            default -> {
                                System.out.println("Invalid input");
                                userInput();
                            }
                        }
                    }
                }
            }
            case "e" -> {
                System.out.flush();
                System.out.println("Exiting program.");
            }
            default -> {
                System.out.flush();
                System.out.println("Invalid input");
                userInput();
            }

        }

    }

    public List<HogwartsPerson> filteredList(List<HogwartsPerson> persons, String houseName, String filter, String role){
        List<HogwartsPerson> filteredList = new ArrayList<>();

        if(Objects.equals(filter, "H")){
            filteredList = persons.stream()
                    .filter(p -> {
                        //In case house is null
                        House house = Objects.requireNonNullElse(p.getHouse(), new House(""));
                        return house.getName().equals(houseName);
                    })
                    .collect(Collectors.toList());

        } else if (Objects.equals(filter, "R")){
            filteredList = persons.stream()
                    .filter(p -> p.getRole().equals(role))
                    .collect(Collectors.toList());
        }
        return filteredList;
    }
}
