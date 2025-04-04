package topic.java8concepts.beans;

public class Student {

    private int id;
    private String name;
    private String stream;
    private double grade;
    private long totalMarks;

    public Student(int id, String name, String stream, double grade, long totalMarks) {
        this.id = id;
        this.name = name;
        this.stream = stream;
        this.grade = grade;
        this.totalMarks = totalMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public long getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(long totalMarks) {
        this.totalMarks = totalMarks;
    }
}
