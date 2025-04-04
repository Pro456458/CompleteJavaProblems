package topic.problemssolving.linkedlist;

/**
 * Reversal a LinkedList i.e. [10]->[20]->[30]->null will become [30]->[20]->[10]->null<br>
 * Point to remember<br><br>
 * Need 2 extra pointer node i.e. Pre , Curr and one temporary variable temp for manipulation<br>
 * Initially Point curr to head<br>
 * Now to do reversal take a pair of 1st 2 node i.e. [10]->[20] and reverse it<br>
 * 1st before assigning Curr.next to previous assign it to temp<br>
 * 2nd assign curr.next=pre; and pre = curr;<br>
 * 3rd curr = temp<br>
 * we need to repeat this process until curr is not reach to null<br><br>
 * time complexity O(n)
 * space complexity O(1)
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        // place to test reverse method
    }

    public Node<Integer> reverse(Node<Integer> head){
        Node<Integer> curr = head;
        Node<Integer> pre=null;
        while(curr!=null){
            Node<Integer> temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
}
