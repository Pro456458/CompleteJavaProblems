package topic.corejavaconcepts.serialization;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>What will be the output of this program, and why?<b/><br><br>
 *
 * Answer<br><br>
 *
 * 1. Serialization:<br>
 * - The Child object is serialized to a file named child.ser using ObjectOutputStream.<br>
 *    - The Parent class implements Serializable, which means that the Child class inherits the serialization behavior of the Parent class, even though the Child class does not explicitly implement Serializable.<br><br>
 *
 * 2. Deserialization:<br>
 *    - When the object is deserialized using ObjectInputStream, the Child class is restored from the serialized file.<br>
 *    - The deserialized object will have both the fields x (from the Parent class) and y (from the Child class).<br><br>
 *
 * 3. What happens during deserialization?<br>
 *    - The field x is restored from the parent class because it was part of the serialized object (as Parent is serializable).<br>
 *    - The field y is also restored from the Child class.<br><br>
 *
 * 4. The output:<br>
 *    - When you run the code:<br>
 *      java<br>
 *      System.out.println("x = " + deserializedChild.x);  // Prints 10<br>
 *      System.out.println("y = " + deserializedChild.y);  // Prints 20<br>
 *
 */
public class TestSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serialization
        Child child = new Child();
        FileOutputStream fileOutputStream = new FileOutputStream("child.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(child);

        //Deserialization
        FileInputStream fileInputStream = new FileInputStream("child.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Child deserializeChile = (Child) objectInputStream.readObject();

        System.out.println(deserializeChile.x);
        System.out.println(deserializeChile.y);

        String s = "assdfgadss";

        s.chars();

        Stream<String> stream = Arrays.stream(s.split(""));
        LinkedHashMap<String, Long> collect = stream.collect
                (Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        Map<String, Long> collect1 = stream.collect
                (Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));


        collect.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);




    }
}


