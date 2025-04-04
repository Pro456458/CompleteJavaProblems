package topic.corejavaconcepts.memorymanagement.stackandheap;

/**
 *  A StackOverflowError in Java occurs when the stack memory allocated for a program is exhausted.<br><br>
 *  Below main method will throw<br><br>
 *  Exception in thread "main" java.lang.StackOverflowError<br>
 * 	at topic.corejavaconcepts.memorymanagement.stackandheap.ExampleStackOverFlow.<init>(ExampleStackOverFlow.java:10)<br>
 * 	at topic.corejavaconcepts.memorymanagement.stackandheap.ExampleStackOverFlow.<init>(ExampleStackOverFlow.java:10)<br>
 * 	Disconnected from the target VM, address: '127.0.0.1:62840', transport: 'socket'<br>
 */
public class ExampleStackOverFlow {

    public static void main(String[] args) {
        new ExampleStackOverFlow();
    }

    public ExampleStackOverFlow() {
        new ExampleStackOverFlow();
    }
}
