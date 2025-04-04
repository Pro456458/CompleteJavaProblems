package topic.java8concepts.beans;

public class Jan2025BenchStudent {

    private int grade;
    private String name;
    private String carOwned;

    public Jan2025BenchStudent(int grade, String name, String carOwned) {
        this.grade = grade;
        this.name = name;
        this.carOwned = carOwned;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getCarOwned() {
        return carOwned;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                ", grade=" + grade + '\'' +
                ", carOwned='" + carOwned + '\'' +
                '}';
    }
}
