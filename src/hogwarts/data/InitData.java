package hogwarts.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hogwarts.application.StudentController;
import hogwarts.application.TeacherController;
import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class InitData {
    private StudentController studentController;
    private TeacherController teacherController;
    House[] housesArray = createHouses();

    public InitData(@NotNull StudentController studentController, @NotNull TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }


    public void initData() {
        // Create students
        fillStudentsList();

        // Create teachers
        fillTeachersList();
    }

    private void fillStudentsList() {
        try (FileReader reader = new FileReader("C:/Users/malte/Documents/GitHub/java-harry-potter-aflevering/hogwarts-opgave/src/hogwarts/data/students.json")) {
            JsonArray studentsJSON = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : studentsJSON) {

                String name = element.getAsJsonObject().get("name").getAsString();

                int age;

                if (element.getAsJsonObject().get("dateOfBirth").isJsonNull()) {
                        age = 0;
                    } else {
                        age = getAgeFromString(element.getAsJsonObject().get("dateOfBirth").getAsString());
                    }

                House house = findHouseByName(element.getAsJsonObject().get("house").getAsString());
                studentController.createStudent(new HogwartsStudent(name, age, house, false));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillTeachersList() {
         try (FileReader reader = new FileReader("C:/Users/malte/Documents/GitHub/java-harry-potter-aflevering/hogwarts-opgave/src/hogwarts/data/staff.json")) {
            JsonArray teachersJSON = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : teachersJSON) {

                String name = element.getAsJsonObject().get("name").getAsString();

                int age;

                if (element.getAsJsonObject().get("dateOfBirth").isJsonNull()) {
                    age = 0;
                } else {
                    age = getAgeFromString(element.getAsJsonObject().get("dateOfBirth").getAsString());
                }

                House house = findHouseByName(element.getAsJsonObject().get("house").getAsString());
                teacherController.createTeacher(new HogwartsTeacher(name, age, house, false));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getAgeFromString(String ageString) {
        if (ageString.equals("null")) {
             return 0;
        } else {
            String[] stringArray = ageString.split("-");

            int day = Integer.parseInt(stringArray[0]);
            int month = Integer.parseInt(stringArray[1]);
            int year = Integer.parseInt(stringArray[2]);

            LocalDate birthDate = LocalDate.of(year, month, day);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Calculate the period between the birthDate and currentDate
            Period period = Period.between(birthDate, currentDate);

            return period.getYears();

        }
    }

    private static House[] createHouses() {
        House[] housesArray = new House[4];
        housesArray[0] = new House("Gryffindor", "Godric Gryffindor", new String[]{"scarlet", "gold"});
        housesArray[1] = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"yellow", "black"});
        housesArray[2] = new House("Ravenclaw", "Rowena Ravenclaw", new String[]{"blue", "bronze"});
        housesArray[3] = new House("Slytherin", "Salazar Slytherin", new String[]{"green", "silver"});
        return housesArray;
    }

    public House findHouseByName(String name) {
        for (House house : housesArray) {
            if (house.getName().equals(name)) {
                return house;
            }
        }
        return null;
    }
}
