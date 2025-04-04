package topic.problemssolving.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTraverse {

    public static void main(String[] args) {
        Node<Integer> head = LinkedListCreation.createStaticLinkedList();

        LinkedListTraverse linkedListTraverse = new LinkedListTraverse();
        linkedListTraverse.traverseInLinkedList(head);
    }

    public void traverseInLinkedList(Node<Integer> head) {
        List<String> integerList = new ArrayList<>();

        while(head !=null){
            integerList.add(String.valueOf(head.data)); // travels to each Node and store data in List to print
            head = head.next;
        }

        System.out.println(integerList);
    }
}
