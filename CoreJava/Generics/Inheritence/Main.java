package CoreJava.Generics.Inheritence;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {


    public static void printUser(Users user) {
        System.out.println(user.getName());
        user.login();
    }

    public static void main(String[] args) {
        Student student1 = new Student("Kritica", 12323, "java");
        student1.login();
        student1.attendClass();
        student1.logout();

        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(new Student("Sachin", 12324, "python"));
        students.add(new Student("Rohit", 12325, "javascript"));

        students.forEach(student -> {
            student.login();
            student.attendClass();
            student.logout();
        });

        List<Users> users = new ArrayList<Users>();
        users.add(student1);
        users.forEach(user -> {
            user.login();
            user.logout();
        });

        List<Instructor> instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Kritica", 979798, 27, 5.0));
        instructors.add(new Instructor("Sachin", 89778, 30, 4.7));


        List<TemporaryInstructor> temporaryInstructors = new ArrayList<TemporaryInstructor>();
        temporaryInstructors.add(new TemporaryInstructor("Kritica", 979798, 27, 5.0, TRUE));
        temporaryInstructors.add(new TemporaryInstructor("Sachin", 89778, 30, 4.7, FALSE));

        //list of user is different from list of instructor.
        // List of user is parent class of list of instructor.
        // So, we can't pass list of instructor as argument in printUsers method.
        // But, we can pass list of instructor as argument in printUser method
        // because printUser method accept single user as argument
        // and instructor is a child class of user. So, we can pass single instructor as
        // argument in printUser method.
        Users u = new Instructor("Rohit", 89778, 30, 4.7); //Valid
        //List<Users> us=instructors; // InValid because list of user is different from list of instructor.

        Users user = new Users();
        user.printUsers(instructors);// Print Users method should be generic and accept child classes.

        new Instructor().printInstructorsAndUsers(instructors);
        // new Instructor().printInstructorsAndUsers(users);
        new Instructor().printInstructorsAndUsers(temporaryInstructors);
    }
}
