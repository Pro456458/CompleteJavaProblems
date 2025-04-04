package topic.problemssolving.linkedlist;

/**
 * LinkedListCreation provide method to create 3 type of LinkedList <br>
 * 1) sample Fixed Sized LinkedList with 4 node <br>
 * 2) dynamic LinkedList with N numbers of Nodes <br>
 * 3) blank ListList with 1 Node contain data as 0 <br><br>
 *
 * Check class <u>LinkedListInsertion</u> and <u>LinkedListTraverse</u> to use this class <br><br>
 * Time Complexity: O(1) - Creating an empty linked list is a constant-time operation. <br>
 * Space Complexity: O(1) - The space required is constant as it only involves initializing a reference to the head node.<br>
 */
public class LinkedListCreation {


    /**
     * Run this main method to show how createStaticLinkedList() and create(int... numbers) methods works
     */
    public static void main(String[] args) {
        createStaticLinkedList();

        LinkedListCreation linkedListCreation = new LinkedListCreation();
        linkedListCreation.createDynamicLinkedList(100, 200, 300, 400);

    }

    /**
     * Creates a dynamic linked list consist n numbers of element <br><br>
     * Used Varargs (variable-length arguments : was introduced in Java 5) as a method argument which allow you to pass a variable number of arguments to a method <br><br>
     * Example : createDynamicLinkedList(1,2,3); OR createDynamicLinkedList(10,20,14,50,60)<br><br>
     * @param numbers which can be used just like an array within the method
     * @return head node of sample linked list
     */
    public Node<Integer> createDynamicLinkedList(int... numbers){

        Node<Integer> head = new Node<>(numbers[0]);
        Node<Integer> curr = head;

        for(int i = 1;i<numbers.length;i++){
            curr.next= new Node<>(numbers[i]);
            curr= curr.next;
        }
        return head;
    }

    /**
     *
     * @return a single node of linked-list as head containing data as 0
     * onc can use this to add new element in this linked-list
     */
    public Node<Integer> createBlankLinkedList() {
        return new Node<>(0);
    }



    /**
     * Creates a sample linked list consist of 4 element [10,20,30,40]
     * @return head node of sample linked list consist 4 element i.e [10,20,30,40]
     */
    public static Node<Integer> createStaticLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;

        return n1; //returning n1 as head
    }

}


