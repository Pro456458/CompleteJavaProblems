package topic.problemssolving.linkedlist;

/**
 * To know more use of this class Visit Main.java class under same package
 */
public class LinkedListInsertion {

    public static void main(String[] args) {
        // use space to test functionally
    }

    /**
     * Time Complexity: O(1) - Inserting at the beginning involves updating the head reference, which is a constant-time operation.
     * Space Complexity: O(1) - No additional space is required apart from the new node
     */
    public Node<Integer> insertAtStart(int data, Node<Integer> head ) {
        Node<Integer> curr=new Node<>(data);
        curr.next =head;
        return curr;
    }

    /**
     *Time Complexity: O(n) - Inserting at the end requires traversing the entire list to find the last node, which takes linear time.
     * Space Complexity: O(1) - No additional space is required apart from the new node.
     */
    public Node<Integer> insertAtEnd(int data, Node<Integer> head) {

        // create a node that need to add
        Node<Integer> toAdd = new Node<>(data);

        // create temp Node which reference to the head node and used to travel across the linked-list
        Node<Integer> curr = head;

        //Travel to the reference of last node
        while(curr.next!=null){
            curr = curr.next;
        }

        //add new node to last's Node next
        curr.next=toAdd;        //at this stage curr.next; hold the reference of last node

        return head; // once new node is added to the last node, head will be updated auto as curr and head both pointing to the same linked-list
    }


    /**
     * Time Complexity: O(n) - Inserting at a specific position requires traversing the list to that position, which takes linear time.
     * Space Complexity: O(1) - No additional space is required apart from the new node.
     */
    public Node<Integer> insertAtPosition(int pos, int data, Node<Integer> head ) {

        Node<Integer> toAdd = new Node<>(data);

        //if poss=0 i.e. data need to insert in start
        if(pos==0)
            return insertAtStart(data,head);

        //for inserting to the specific position , you have to find the reference of node just before it
        Node<Integer> prev = head;

        for(int i=0; i<pos-1 ;i++){
            prev = prev.next;
        }

        // Note : if you change the order of below line , you will lose the node reference
        toAdd.next=prev.next;
        prev.next = toAdd;

        return head;

    }

}
