package topic.corejavaconcepts.memorymanagement.classloader;

import java.io.*;

/**
 * The CustomClassLoader class extends ClassLoader.
 * The findClass method is overridden to load the class data from the specified directory.
 * The loadClassData method reads the class file into a byte array.
 * The main method demonstrates how to use the custom class loader to load and invoke the HelloWorld class.
 */
public class CustomClassLoader extends ClassLoader {
    private final String classpath;

    public CustomClassLoader(String classpath) {
        this.classpath = classpath;
    }

    public static void main(String[] args) {
        try {
            CustomClassLoader loader = new CustomClassLoader("");
            Class<?> clazz = loader.loadClass("topic.corejavaconcepts.memorymanagement.classloader.Test");
            Object instance = clazz.newInstance();
            clazz.getMethod("sayHello").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData.length==0) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className){
        String fileName = classpath + File.separator +
                className.replace(".",File.separator)+".class";

        try(InputStream inputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream()){
            int nextValue;
            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }
            return byteStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }

    }
}
