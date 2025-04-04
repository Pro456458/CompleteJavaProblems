package topic.designpattern.creational.prototype;

public class DeepCopyPrototypeTesting {

    public static void main(String[] args) {

        Address address = new Address("DeepCopy Address");
        DeepCopyPrototype original = new DeepCopyPrototype(1,"DeepCopy",address);

        DeepCopyPrototype clone;

        try {
            clone =(DeepCopyPrototype) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(original);
        System.out.println(clone);

        System.out.println(original==clone);


    }

}



class DeepCopyPrototype implements Cloneable{
    private int id;
    private String name;
    private Address address;
    public DeepCopyPrototype(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "DeepCopyPrototypeTesting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       DeepCopyPrototype cloned = (DeepCopyPrototype) super.clone();
       cloned.address = (Address) address.clone();
       return cloned;
    }
}

class Address implements Cloneable{
    private String completeAddress;

    public Address(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "completeAddress='" + completeAddress + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}