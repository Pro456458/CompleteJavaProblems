package topic.java8concepts.functionalinterfaces;

import java.util.function.*;

public class DefaultFunctionalInterfaceInJava8Example {

    public static void main(String[] args) {

        exampleOfFunctionFunctionalInterface();
        System.out.println("=========================");
        exampleOfConsumerFunctionInterface();
        System.out.println("=========================");
        exampleOfSupplierFunctionalInterface();
        System.out.println("=========================");
        exampleOfPredicateFunctionInterface();

    }
    /**
     *Predicate take 1 parameter as input and return boolean after processing;
     **/
    private static void exampleOfPredicateFunctionInterface() {
        Predicate<Integer> integerPredicate = integer -> integer%2 ==0;
        System.out.println(integerPredicate.test(30));
    }

    /**
     *Supplier didn't take input and return the result after processing using get method;
     **/
    private static void exampleOfSupplierFunctionalInterface() {
        Supplier<Integer> supplier = () ->{
            System.out.println("Supplier didn't take input and return the result after processing");
            return 10*10;
        };
        System.out.println(supplier.get());
    }

    /**
     Consumer have one abstract method i.e accept which accept only one input and not return anything
     **/
    private static void exampleOfConsumerFunctionInterface() {
        Consumer<String> stringConsumer= s -> System.out.println(s);
        stringConsumer.accept("Consumer have one abstract method i.e accept which accept only one input and not return anything.");
    }

    /**
     * Function have 1 method i.e. apply which receive 1st parameter as input and apply some logic and return 2nd functional argument as a return type
     * ===================================================
     * There is a replacement of above function which accept 1st parameter as Integer and 2nd parameter as String
     * ===Example is below=====
     * IntFunction also have 1 method i.e apply but it take only int parameter as input and apply some logic and return functional argument as a return type
     */
    private static void exampleOfFunctionFunctionalInterface() {

        Function<Integer,String> functionInterface = integer -> {
            System.out.println("Function have 1 method i.e apply which receive 1st parameter as input and apply some logic and return 2nd functional argument as a return type");
            return integer.toString();
        };
        String apply = functionInterface.apply(10);
        System.out.println(apply);

        //===================================================//

        IntFunction<String> stringIntFunction = value -> {
            System.out.println("IntFunction also have 1 method i.e apply but it take only int parameter as input and apply some logic and return functional argument as a return type");
            return String.valueOf(value);
        };

        System.out.println(stringIntFunction.apply(100));

        //==================================================//

        /*
         * Other Example of same type of functionalInterface with different purpose
         */
        LongFunction<Double> doubleLongFunction;
        DoubleToIntFunction doubleToIntFunction = value -> {return (int) value;};
        ToDoubleFunction toDoubleFunction = value -> (double) value; // to convert given Wrapper Object to its primitive data type


    }
}