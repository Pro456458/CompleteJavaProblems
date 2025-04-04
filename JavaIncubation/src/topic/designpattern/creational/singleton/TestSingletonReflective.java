package topic.designpattern.creational.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonReflective implements Serializable {


    public static void main(String[] args) throws NoSuchMethodException {


        SingletonReflective singletonReflective1 = SingletonReflective.getInstance();
        SingletonReflective singletonReflective2 = SingletonReflective.getInstance();
        SingletonReflective singletonReflective3;


        // multiple object compression before using reflection
        System.out.println(singletonReflective1);
        System.out.println(singletonReflective2);
        System.out.println(singletonReflective1==singletonReflective2);




        // use reflection to access the private constructor
        Constructor<?> constructor = SingletonReflective.class.getDeclaredConstructor();

        //Purpose of setAccessible(true)
        //Access Control: By default, Java enforces access control checks to prevent unauthorized access to private members of a class. This includes private constructors, methods, and fields.
        //Bypassing Access Control: The setAccessible(true) method is part of the AccessibleObject class, which Constructor, Method, and Field classes extend. When you call setAccessible(true), it disables Java's access control checks for that specific Constructor, Method, or Field object.
        constructor.setAccessible(true);

        try {

        singletonReflective3 = (SingletonReflective) constructor.newInstance();


        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // // multiple object compression after using reflection

        System.out.println(singletonReflective3);
        System.out.println(singletonReflective1==singletonReflective3);
        System.out.println(singletonReflective2==singletonReflective3);


    }
}



class SingletonReflective{

    private static final SingletonReflective singletonReflective = new SingletonReflective();

    // private constructor to protect object instantiation
    private SingletonReflective(){

        // to prevent the singleton violation by Reflection we can throw an exception
        // if someone is trying to call private constructor using Reflection

        // Uncomment below line to check the result
        /*
        if(singletonReflective!=null)
            throw new IllegalStateException("Object already Created");
        */

    }



    public static SingletonReflective getInstance(){
        return  singletonReflective;
    }




}
