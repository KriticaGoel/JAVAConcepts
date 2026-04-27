package CoreJava.Generics.Inheritence;

import java.util.List;

public class Instructor extends Users {

    private Integer salary;
    private Double avgRating;

    public Instructor() {

    }

    public Instructor(String name, Integer phoneNumber, Integer salary, Double avgRating) {
        super(name, phoneNumber);
        this.salary = salary;
        this.avgRating = avgRating;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void schedule() {
        System.out.printf("Instructor %s is scheduling classes %n", this.getName());
    }

    public <E extends Instructor> void printInstructorsAndUsers(List<E> users) {

        users.forEach(user -> {
            System.out.println(user.getName());
            user.login();
            user.schedule();
            //user.attendClass();
        });
    }
}
