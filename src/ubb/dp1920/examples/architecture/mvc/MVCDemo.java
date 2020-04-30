package ubb.dp1920.examples.architecture.mvc;

/**
 * Source: https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 */
public class MVCDemo {
    public static void main(String[] args) {

        // fetch student record based on his roll no from the database
        Student model = retriveStudentFromDatabase();

        // Create a view : to write student details on console
        StudentViewConsole view = new StudentViewConsole();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}