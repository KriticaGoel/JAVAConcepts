package CoreJava.Generics.Inheritence;

public class Student extends Users {
    private String course;

    public Student(String name, Integer phoneNumber, String course) {
        super(name, phoneNumber);
        this.course = course;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void attendClass() {
        System.out.printf("Student %s is attending class of course %s %n", this.getName(), this.course);
    }


}
