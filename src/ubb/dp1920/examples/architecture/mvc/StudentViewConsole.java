package ubb.dp1920.examples.architecture.mvc;

/**
 * Source: https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm
 */
public class StudentViewConsole implements StudentView {
    public void printStudentDetails(String studentName, String studentRollNo) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}