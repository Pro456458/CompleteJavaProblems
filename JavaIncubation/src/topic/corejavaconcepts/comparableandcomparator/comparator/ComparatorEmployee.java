package topic.corejavaconcepts.comparableandcomparator.comparator;

import java.util.Objects;

public class ComparatorEmployee{

    private int id;
    private String name;

    public ComparatorEmployee(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {

        //1) Ensure Object is being compare is of correct type
        if(this == obj) return true;

        // return false if object is being compare is null
        if(obj == null || getClass() != obj.getClass()) return false;

        ComparatorEmployee emp = (ComparatorEmployee) obj;

        //only compare field that are significant for equality
        return this.id == emp.id && this.name.equals(emp.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }

    @Override
    public String toString() {
        return "ComparableEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }




}
