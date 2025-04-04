package topic.designpattern.creational.singleton;

public class SingletonDesignPatternExample {

    public static void main(String[] args) {


        //Object creation using Eager Loading but not thread safe
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();

        System.out.println( singletonEager1);
        System.out.println( singletonEager2);
        System.out.println(singletonEager1 == singletonEager2);


        //Object creation using static block but lazy loading and not thread safe
        SingleTonStaticBlock singleTonStaticBlock1 = SingleTonStaticBlock.getInstance();
        SingleTonStaticBlock singleTonStaticBlock2 = SingleTonStaticBlock.getInstance();

        System.out.println(singleTonStaticBlock1);
        System.out.println(singleTonStaticBlock2);
        System.out.println(singleTonStaticBlock1==singleTonStaticBlock2);


        //Object Creation using synchronization but eager loading
        SingletonThreadSafe singletonThreadSafe1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe singletonThreadSafe2 = SingletonThreadSafe.getInstance();

        System.out.println(singletonThreadSafe1);
        System.out.println(singletonThreadSafe2);
        System.out.println(singletonThreadSafe1==singletonThreadSafe2);


        // Object Creation using Eager Loading but not thread save
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();

        System.out.println(singletonLazy1);
        System.out.println(singletonLazy2);
        System.out.println(singletonLazy1 == singletonLazy2);


        //Object creation using inner static class which is lazy loading and thread safe without synchronization overhead
        SingletonBillPugh singletonBillPugh1 = SingletonBillPugh.getInstance();
        SingletonBillPugh singletonBillPugh2 = SingletonBillPugh.getInstance();

        System.out.println(singletonBillPugh1);
        System.out.println(singletonBillPugh1);
        System.out.println(singletonBillPugh1 == singletonBillPugh2);


    }

}


/**
 * Eager initialization of singleton class object
 */
class SingletonEager{

    // create a static instance of the class at the time of declaration only.
    private static final SingletonEager SINGLETONEAGER = new SingletonEager();

    // make constructor private
    private SingletonEager() {}

    // return instance of a class
    public static SingletonEager getInstance(){
        return SINGLETONEAGER;
    }

}

/**
 * Eager initialization of singleton class object with static block
 */
class SingleTonStaticBlock{

    private static SingleTonStaticBlock singleTonStaticBlock;

    //private constructor to  prevent instantiation
    private SingleTonStaticBlock(){}

    static {
        singleTonStaticBlock = new SingleTonStaticBlock();
    }

    public static SingleTonStaticBlock getInstance(){
        return singleTonStaticBlock;
    }

}

/**
 * Lazy initialization of singleton class object
 */
class SingletonLazy{

    //don't create instance at the time of declaration
    private static SingletonLazy singletonLazy;

    //private constructor to protect object instantiation
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(singletonLazy==null)
            singletonLazy = new SingletonLazy();

        return singletonLazy;

        // can replace by requireNonNullElseGet method introduce in java 9
        //return Objects.requireNonNullElseGet(singletonLazy, SingletonLazy::new);

    }

}


/**
 * Eager initialization but thread safe Singleton class object creation
 */
class SingletonThreadSafe{

    private static SingletonThreadSafe singletonThreadSafe;

    //private constructor to protect object instantiation
    private SingletonThreadSafe(){

    }

    public static synchronized SingletonThreadSafe getInstance(){
        if(singletonThreadSafe == null)
            singletonThreadSafe = new SingletonThreadSafe();

        return singletonThreadSafe;
    }
}


/**
 * Lazy Initialization and thread save singleton class object creation
 */
class SingletonBillPugh{
    private static SingletonBillPugh singletonBillPugh;

    //private constructor to protect singleton object instantiation
    private SingletonBillPugh(){}

    //inner static class responsible for holding the singleton object
    private static class SingletonHelper{
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance(){
        return SingletonHelper.INSTANCE;
    }



}

