package topic.corejavaconcepts.collectioninterface;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "David");
        Employee e2 = new Employee(1, "Lyla");

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        Set<Employee> set = new HashSet<>();

        set.add(e1);
        set.add(e2);

        System.out.println(set);


    }

}

class Employee{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

