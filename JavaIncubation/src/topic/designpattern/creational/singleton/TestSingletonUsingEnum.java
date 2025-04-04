package topic.designpattern.creational.singleton;

/**
 * The enum guarantees thread safety, so you don't need to worry about synchronization issues
 * when logging messages from multiple threads in below example
 */
public class TestSingletonUsingEnum {

    public static void main(String[] args) {

        LoggerEnum loggerEnum1 = LoggerEnum.INSTANCE;
        LoggerEnum loggerEnum2 = LoggerEnum.INSTANCE;


        System.out.println(loggerEnum1.hashCode());
        System.out.println(loggerEnum2.hashCode());
        System.out.println(loggerEnum1==loggerEnum2);

        loggerEnum1.log("Msg 1");
        loggerEnum2.log("Msg 1");

    }
}
