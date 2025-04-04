package topic.client.expedia;

import java.util.Random;

/**
 * Deleting a node from a linked list when the head is not provided.
 * Create a LinkedList Class with Node and Data.
 * 1) Create a method to add the element into the linked list
 * 2) Create a method to delete a specific node without using head
 *
 */
public class DeleteNodeFromLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        // iterate a loop to add random element in the list
        for(int i=0;i<10;i++) {
            linkedList.add(new Random().nextInt(100));
        }

        // print the list
        linkedList.print();

        //remove 4th element without passing head
        linkedList.removeNodeWithoutHead(
                linkedList.getHead().getNext()
                        .getNext().getNext());

        //print the list after deleting the specific node
        linkedList.print();

    }
}


class LinkedList{

    private int size=0;
    private Node<Integer> head;

    public Node<Integer> add(int data){

        if(this.head==null)
            return addInTheBeginning(data);

        Node<Integer> newNode=new Node<>(data);

        Node<Integer> current=this.head;

        while(current.getNext()!=null){
            current =current.getNext();
        }

        current.setNext(newNode);
        this.size--;

        return this.head;
    }

    private Node<Integer> addInTheBeginning(int data) {
        this.head = new Node<>(data);
        this.size++;
        return head;
    }

    public void removeNodeWithoutHead(Node<Integer> node){

        if(node==null || node.getNext()==null)
            throw new  IllegalArgumentException("node to be deleted is null or last node.");

        System.out.println("Node ["+node.getData()+"] is deleted.");

        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());


        this.size--;
    }


    public void print(){
        Node<Integer> current = head;

        System.out.print("[");
        while(current.getNext()!=null){
            System.out.print(current.getData()+"]->[");
            current=current.getNext();
        }
        System.out.print(current.getData()+"]");
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public Node<Integer> getHead() {
        return head;
    }
}



class Node<T>{

    private int data;

    private Node<T> next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


}
