package topic.corejavaconcepts.comparableandcomparator.comparable;

public class Employee {

    String alice;
    String hr;
    int i;

    public Employee(String alice, String hr, int i) {
        this.alice = alice;
        this.hr = hr;
        this.i = i;
    }


    public String getAlice() {
        return alice;
    }

    public void setAlice(String alice) {
        this.alice = alice;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "alice='" + alice + '\'' +
                ", hr='" + hr + '\'' +
                ", i=" + i +
                '}';
    }
}
