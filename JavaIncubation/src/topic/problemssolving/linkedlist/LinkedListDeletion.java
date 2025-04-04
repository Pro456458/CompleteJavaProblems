package topic.problemssolving.linkedlist;

/**
 * To know more use of this class Visit Main.java class under same package
 */
public class LinkedListDeletion {

    /**
     *
     * If You need to run this class separately use main method to call the method and pass value
     */
    public static void main(String[] args) {
        // use space to test functionally
    }

    public Node<Integer> deleteElementFromBeginning(Node<Integer> head) {
        return head.next;
    }

    public Node<Integer> deleteElementFromEnd(Node<Integer> head) {
        Node<Integer> curr = head;

        while(curr.next.next!=null){
            curr= curr.next;
        }
        curr.next=null;

        return head;
    }

    public Node<Integer> deleteElementAtPosition(int poss, Node<Integer> head) {

        if(poss==0)
            throw  new RuntimeException("Invalid Position");
        if(poss==1)
            return deleteElementFromBeginning(head);

        Node<Integer> prev= head;

        for (int i=1;i<poss-1;i++){
            prev=prev.next;
        }

        if(prev.next==null || prev.next.next==null)
            throw new RuntimeException("Invalid Possition..!!");

        prev.next = prev.next.next;

        return head;
    }
}
