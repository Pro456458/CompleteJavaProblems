package topic.corejavaconcepts.comparableandcomparator.comparable;

import java.util.Objects;

public class ComparableEmployee implements Comparable<ComparableEmployee>{

    private int id;
    private String name;

    public ComparableEmployee(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(ComparableEmployee e){

        //int compareId = (id < e.id) ? -1 : ((id == e.id) ? 0 : 1);

        int compareId = Integer.compare(this.id,e.id);

        if( compareId !=0 )
            return compareId;

        return this.name.compareTo(e.name) ;
    }

    @Override
    public boolean equals(Object obj) {

        //1) Ensure Object is being compare is of correct type
        if(this == obj) return true;

        // return false if object is being compare is null
        if(obj == null || getClass() != obj.getClass()) return false;

        ComparableEmployee emp = (ComparableEmployee) obj;

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


}
