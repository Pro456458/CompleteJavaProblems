package topic.corejavaconcepts.memorymanagement.stackandheap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * An OutOfMemoryError occurs when the JVM cannot allocate an object because it is out of heap memory<br><br>
 * On running below main method will throw<br><br>
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space<br>
 * 	at java.base/java.util.HashMap.newNode(HashMap.java:1901)<br>
 * 	at java.base/java.util.HashMap.putVal(HashMap.java:629)<br>
 * 	at java.base/java.util.HashMap.put(HashMap.java:610)<br>
 * 	at topic.corejavaconcepts.memorymanagement.stackandheap.ExampleOfOutOfMemory.main(ExampleOfOutOfMemory.java:23)
 */
public class ExampleOfOutOfMemory {

    private ExampleOfOutOfMemory exampleOfOutOfMemory;

    public static void main(String[] args) {

        Map<Integer,String> integerStringMap = new HashMap<>();
        Random random = new Random();
        // Using parallel stream to generate random integers and put them into the map
        IntStream.generate(random::nextInt)
                .parallel()
                .forEach(i -> integerStringMap.put(i, "This is going to break"));

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.exampleOfOutOfMemory=new ExampleOfOutOfMemory();
    }
}
