package topic.java8concepts.functionalinterfaces.custom;

public class CustomFunctionalInterfaceExample {

    public static void main(String[] args) {

        CustomFunctionalInterface customFunctionalInterface =() ->
            System.out.println("this is function interface method");

        customFunctionalInterface.print();

    }
}
