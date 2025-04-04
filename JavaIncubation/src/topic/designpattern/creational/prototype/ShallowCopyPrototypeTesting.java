package topic.designpattern.creational.prototype;

public class ShallowCopyPrototypeTesting {

    public static void main(String[] args) {
        ShallowCopyPrototype original =
                new ShallowCopyPrototype(1,"shallowCopy");

        System.out.println(original.toString());

        ShallowCopyPrototype clone;

        try {
            clone = (ShallowCopyPrototype) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println( clone.toString());

        System.out.println(original==clone);


    }

}


class ShallowCopyPrototype implements Cloneable{
    private int id;
    private String name;

    public ShallowCopyPrototype(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ShallowCopyPrototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
