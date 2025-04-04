package topic.corejavaconcepts.serialization;

import java.io.Serializable;

public class  Parent implements Serializable {
    transient int x =10;
}

class Child extends Parent{
    int y =20;
}
