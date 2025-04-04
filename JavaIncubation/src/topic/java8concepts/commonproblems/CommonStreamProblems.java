package topic.java8concepts.commonproblems;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class CommonStreamProblems {

    public static void main(String[] args) {

        ArrayList<Student> students = getStudents();
        students.forEach(System.out::println);
        System.out.println("===================================");

        List<Student> sortedStudentsGradeWise=students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).toList();
        System.out.println("select top grade student:"+sortedStudentsGradeWise.stream().findFirst());

        System.out.println("===================================");

        //select top grade student from each cardOwned


        //students.stream().sorted(Comparator.comparingInt())
        //students.stream().collect(Collectors.groupingBy(Student::getCarOwned));

        //studentsWithCarOwned.forEach((k,v)-> System.out.println(k+":"+v));
        //System.out.println("===================================");

        Optional<Map.Entry<String, Long>> max = students.stream().collect(Collectors.groupingBy(Student::getCarOwned, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());


        max.ifPresentOrElse (stringLongEntry -> System.out.println(stringLongEntry.getValue())
        , () -> System.out.println("Value not present"));


        Map<String, Optional<Student>> collect = students.stream().collect(
                Collectors.groupingBy(Student::getCarOwned,
                        Collectors.maxBy(Comparator.comparingInt(Student::getGrade))
                ));



    }

    private static ArrayList<Student> getStudents() {
        ArrayList<Student> alist = new ArrayList<>();

        alist.add(new Student (10,"Pro", "Nexon"));
        alist.add(new Student (6,"Pro1", "Nexon"));
        alist.add(new Student (8,"Poo", "Volvo"));
        alist.add(new Student (14,"Poo1", "Volvo"));
        alist.add(new Student (11,"Rajni", "HondaCity"));
        alist.add(new Student (9,"Kartik", "HondaCity"));

        return alist;
    }


}


class Student{

    private int grade;
    private String name;
    private String carOwned;

    public Student(int grade, String name, String carOwned) {
        this.grade = grade;
        this.name = name;
        this.carOwned = carOwned;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarOwned() {
        return carOwned;
    }

    public void setCarOwned(String carOwned) {
        this.carOwned = carOwned;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", carOwned='" + carOwned + '\'' +
                '}';
    }
}
