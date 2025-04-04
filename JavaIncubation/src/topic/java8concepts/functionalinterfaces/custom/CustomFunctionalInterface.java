package topic.java8concepts.functionalinterfaces.custom;

@FunctionalInterface
public interface CustomFunctionalInterface{

    default void defaultMethod(){System.out.println("default method is base class");}
    void print();
}
