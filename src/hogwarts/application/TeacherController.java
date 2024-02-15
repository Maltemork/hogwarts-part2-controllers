package hogwarts.application;

import generic.Teacher;
import hogwarts.data.HogwartsTeacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherController {

    private final Map<Integer, HogwartsTeacher> allTeachers = new HashMap<>();

    private int lastId = 0;

    public void createTeacher(HogwartsTeacher teacher){
        lastId++;
        allTeachers.put(lastId, teacher);
    }
    public Teacher getTeacher(int id){
        return allTeachers.get(id);
    }
    public List<HogwartsTeacher> getAllTeachers(){
        return new ArrayList<>(allTeachers.values());
    }
}