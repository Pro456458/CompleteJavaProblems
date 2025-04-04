package topic.corejavaconcepts.collectioninterface.mapinterface;

import java.util.LinkedList;

/**
 * Below is the example of custom hashtable implementation where <br>
 * if more than one key produce same hashcode ( i.e. hash collision) <br>
 * than the new entry is simply added to the linked list at that position. (i.e. chaining) <br>
 * Chaining is a technique where each position in the hash table (also known as a bucket) <br>
 * points to a linked list of entries that have the same hash code. <br>
 * When a collision occurs, the new entry is simply added to the linked list at that position.<br>
 */
public class HashTableCollisionExample {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(5);

        for (int i=0; i<5; i++){
            hashTable.put(i,"value-"+i);
        }


        System.out.println("print Hashtable element");
        for (int i=0; i<5; i++){
            System.out.println(hashTable.get(i));
        }

    }


}

 class HashTable {

    private LinkedList<Entry>[] table;  // array of linked-list or you can say bucket of linked list

    public HashTable(int size) {
        this.table = new LinkedList[size];
        for(int i=0;i<size;i++){
            table[i]=new LinkedList<>();
        }
    }

     /**
      * take 2 input key and value and perform below task <br><br>
      * 1) calculate hashcode on the bases of the key and <br>
      * 2) use that hashcode as index to store the value associate with it.<br>
      * @param key
      * @param value
      */
    public void put(int key,String value){
        int hash = getHashCode(key);
        System.out.println("hashcode for the key"+key+" and value "+value+" is :"+hash);

        hash = getLinearProbing(key, hash);

        for(Entry entry : table[hash]){

            if(entry.getKey() == key){
                //update the value if the key is already exist
                entry.setValue(value);
                return;
            }

        }
        // Add a new entry if the key does not exist
        table[hash].add(new Entry(key,value));


    }

     /**
      * Below method is an example of Linear Probing which use to handle collision
      * Incrementally checks the next slot in the array.
      */
     private int getLinearProbing(int key, int hash) {

         LinkedList<Entry> entries = table[hash];

         while (table[hash] != null && entries.get(0).getKey() != key) {
             hash = getHashCode(hash +1);
         }
         return hash;
     }

     /**
      * below method take key as an input and calculate hashcode <br>
      * which further treated as index of a table <br>
      * and calculate the value associate with it. <br>
      * @param key
      * @return value of the first occurrence of the key
      */
     public String get(int key){

        int hash = getHashCode(key);
         System.out.println("hashcode for the key"+key+" is :"+hash);

        for(Entry entry : table[hash]){
            if(entry.getKey()==key){
                // Return the value of the first occurrence of the key
                return entry.getValue();
            }

        }
        // Return null if no value is associated with given key
        return null;
    }

     /**
      *
      * @param key i.e. key of hashtable which is used to generate hashcode. <br>
      *            Hashcode will return either 1 to 2 to produce high collision. <br>
      *            You can change computation to generate unique hashcode. <br>
      * @return hashcode
      */
     private static int getHashCode(int key) {
         return key % 2;
     }

}


class Entry{

    private int key;
    private String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}