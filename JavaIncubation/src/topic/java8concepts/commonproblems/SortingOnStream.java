package topic.java8concepts.commonproblems;



import topic.java8concepts.beans.Jan2025BenchStudent;

import java.util.*;
import java.util.stream.Collectors;

public class SortingOnStream {

    private static final ArrayList<Jan2025BenchStudent> jan2025BenchStudents = new ArrayList<>();

    public static void main(String[] args) {

        addStudentsInJan2025Bench();

        printDetail(getJan2025BenchStudents(),"==========Jan 2025 Bench Student Detail========");

        List<Jan2025BenchStudent> sortStudentGradeWise=sortStudentGradeWise(getJan2025BenchStudents());
        printDetail(sortStudentGradeWise,"==========Sort as per Grade========");

        List<Jan2025BenchStudent> sortedStudentGradeWiseAndNameWise = sortStudentGradeWiseAndNameWise(getJan2025BenchStudents());
        printDetail(sortedStudentGradeWiseAndNameWise,"==========Sort as per Grade and Name========");

        //select lowest grade student from Jan 2025 bench
        printDetail(selectLowestGradeStudent(),"==========lowest grade student from Jan 2025 bench========");

        selectStudentFromEachCarOwned();

        selectLowestGradeStudentFromEachCarOwned();


    }

    private static void selectLowestGradeStudentFromEachCarOwned() {

        //select lowest grade student from each carOwned
        Map<String, Jan2025BenchStudent> lowerGradeStudentWithCarOwned = getJan2025BenchStudents()
                .stream()
                .collect(Collectors.groupingBy(Jan2025BenchStudent::getCarOwned,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Jan2025BenchStudent::getGrade)),Optional::get)
                ));

        lowerGradeStudentWithCarOwned.forEach((s, jan2025BenchStudents1) ->
                System.out.println(s+"--"+jan2025BenchStudents1));
    }

    private static void selectStudentFromEachCarOwned() {

        //select student from each carOwned
        Map<String, List<Jan2025BenchStudent>> lowerGradeStudentsWithCardOwned = getJan2025BenchStudents()
                .stream()
                .collect(Collectors
                        .groupingBy(Jan2025BenchStudent::getCarOwned));

        lowerGradeStudentsWithCardOwned.forEach((s, jan2025BenchStudents1) ->
                System.out.println(s+"--"+jan2025BenchStudents1));

        System.out.println("===============================================");
    }


    private static Optional<Jan2025BenchStudent> selectLowestGradeStudent() {
        return getJan2025BenchStudents().stream().min(Comparator.comparingInt(Jan2025BenchStudent::getGrade));
    }

    private static List<Jan2025BenchStudent> sortStudentGradeWiseAndNameWise(List<Jan2025BenchStudent> jan2025BenchStudents) {
        return
                jan2025BenchStudents.stream().sorted(
                        Comparator.comparingInt(Jan2025BenchStudent::getGrade)
                                .thenComparing(Jan2025BenchStudent::getName)
                ).toList();
    }

    private static List<Jan2025BenchStudent> sortStudentGradeWise(List<Jan2025BenchStudent> jan2025BenchStudents) {
        return jan2025BenchStudents.stream()
                .sorted(
                        Comparator.comparingInt(Jan2025BenchStudent::getGrade)
                ).toList();
    }

    private static void printDetail(List<Jan2025BenchStudent> jan2025BenchStudents,String printMsg) {
        System.out.println(printMsg);
        jan2025BenchStudents.forEach(System.out::println);
        System.out.println("==========XXX===========END==========XXX============\n");
    }

    private static void printDetail(Optional<Jan2025BenchStudent> jan2025BenchStudent, String printMsg) {
        System.out.println(printMsg);
        jan2025BenchStudent.ifPresent(System.out::println);
        System.out.println("==========XXX===========END==========XXX============\n");
    }

    private static void addStudentsInJan2025Bench() {
        addStudentInJan2025Bench(10,"Pro","Tata");
        addStudentInJan2025Bench(6,"Pramod","Range Rover");
        addStudentInJan2025Bench(6,"Khrystyna","HondaCity");
        addStudentInJan2025Bench(8,"Petro","Volvo");
        addStudentInJan2025Bench(14,"Ashwani","Kia");
        addStudentInJan2025Bench(11,"Narandera","Tata");
        addStudentInJan2025Bench(9,"Navya","Volvo");
        addStudentInJan2025Bench(10,"Manoj","Range Rover");
    }

    private static void addStudentInJan2025Bench(int grade,String name,String carOwned) {
        jan2025BenchStudents.add(new Jan2025BenchStudent(grade,name,carOwned));
    }

    private static ArrayList<Jan2025BenchStudent> getJan2025BenchStudents(){
        return jan2025BenchStudents;
    }

}