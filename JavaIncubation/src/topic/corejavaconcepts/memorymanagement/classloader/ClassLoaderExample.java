package topic.corejavaconcepts.memorymanagement.classloader;

/**
 * 1) Bootstrap Class Loader: This is the parent of all class loaders and is responsible for loading core Java classes from the rt.jar file, such as classes from the java.lang package.<b><b>
 * 2) Extension Class Loader: This loader loads classes from the ext directory (jre/lib/ext) or any other directory specified by the java.ext.dirs system property. It is a child of the Bootstrap Class Loader.<b><b>
 * 3) System/Application Class Loader: This loader loads classes from the system classpath, which is specified by the CLASSPATH environment variable or the -cp command-line option. It is a child of the Extension Class Loader.<b><b>
 * 4) Custom Class Loaders: Developers can create their own class loaders by extending the ClassLoader class. This is useful for loading classes in a specific way, such as from a network location or an encrypted file.<b><b>
 */
public class ClassLoaderExample {

    public static void main(String[] args) {

        //Note : String Class is present in jdk/jre/lib/rt.jar which is loaded by Bootstrap class loader
        //Below line print null as bootstrap class loader is not part of java
        System.out.println(String.class.getClassLoader());

        //Below 2 line print AppClassLoader as Test class is situated in Environment class path
        // i.e. with in this project and AppClassLoader is responsible for loading file from
        // environment class path
        System.out.println(Test.class.getClassLoader());

        System.out.println(ClassLoaderExample.class.getClassLoader());

    }
}
