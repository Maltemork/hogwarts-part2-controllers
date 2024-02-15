package hogwarts.application;

import hogwarts.data.InitData;


public class Application {

    private final StudentController studentController = new StudentController();
    private final TeacherController teacherController = new TeacherController();
    private final InitData initData = new InitData(studentController, teacherController);
    private final UserInterface userInterface = new UserInterface(studentController, teacherController);

    public static void main(String[] args) {
        var app = new Application();
        app.initApp();
    }

    public void initApp() {
        initData.initData();
        userInterface.start();
    }


}
