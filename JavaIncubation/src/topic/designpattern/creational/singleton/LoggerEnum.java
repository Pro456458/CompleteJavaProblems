package topic.designpattern.creational.singleton;

public enum LoggerEnum {
    INSTANCE;
    public void log(String msg){
        System.out.println("Log: "+msg);
    }
}
