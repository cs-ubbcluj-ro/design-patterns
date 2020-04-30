package ubb.dp1920.examples.architecture.mvc;

/**
 * Source: https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 */
public class StudentController {
    private Student model;
    private StudentViewConsole view;

    public StudentController(Student model, StudentViewConsole view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}