package CoreJava.Generics.Inheritence;

public class TemporaryInstructor extends Instructor {

    private Boolean isPartTime;

    public TemporaryInstructor(String name, Integer phoneNumber, Integer salary, Double avgRating, Boolean isPartTime) {
        super(name, phoneNumber, salary, avgRating);
        this.isPartTime = isPartTime;
    }

    public Boolean getIsPartTime() {
        return this.isPartTime;
    }

    public void setIsPartTime(Boolean isPartTime) {
        this.isPartTime = isPartTime;
    }

    public void attendClass() {
        System.out.printf("Temporary Instructor %s is attending class %n", this.getName());
    }
}
