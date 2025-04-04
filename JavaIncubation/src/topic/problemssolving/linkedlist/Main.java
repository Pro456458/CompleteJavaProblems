package topic.problemssolving.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedListCreation linkedListCreation = new LinkedListCreation();
        LinkedListTraverse linkedListTraverse = new LinkedListTraverse();
        LinkedListInsertion linkedListInsertion = new LinkedListInsertion();

        System.out.println("=== Create a new Linked list with 5 node ====");
        Node<Integer> headNodeOfDynamicLinkedList = createNewLinkedList(linkedListCreation, linkedListTraverse);

        System.out.println("=== Add a new element [5] in the Beginning of Linked list ====");
        Node<Integer> updatedHeadNodeOfDynamicLinkedList = addNewElementInTheBeginning(linkedListInsertion, headNodeOfDynamicLinkedList, linkedListTraverse);

        System.out.println("=== Add a new element [60] in the End of Linked list ====");
        updatedHeadNodeOfDynamicLinkedList = addNewElementAtTheEnd(updatedHeadNodeOfDynamicLinkedList, linkedListInsertion, linkedListTraverse);

        System.out.println("=== Add a new element [70] after 4th position in the Linked list ====");
        addNewElementAtSpecificPosition(linkedListInsertion, updatedHeadNodeOfDynamicLinkedList, linkedListTraverse);

        // delete an element from beginning
        System.out.println("delete an element from beginning");
        LinkedListDeletion linkedListDeletion = new LinkedListDeletion();

        updatedHeadNodeOfDynamicLinkedList = deleteElementAtTheBeginning(updatedHeadNodeOfDynamicLinkedList, linkedListDeletion, linkedListTraverse);

        // delete an element at the end
        System.out.println("delete an element at the end");
        updatedHeadNodeOfDynamicLinkedList = deleteElementFromTheEnd(updatedHeadNodeOfDynamicLinkedList, linkedListDeletion, linkedListTraverse);

        // delete an element at the specific position
        System.out.println("delete an element at the 5th position");
        deleteElementAtTheSpecificPosition(updatedHeadNodeOfDynamicLinkedList, linkedListDeletion, linkedListTraverse);

        //reverse a linkedList
        System.out.println("reverse a linkedList");
        reversalOfLinkedList(updatedHeadNodeOfDynamicLinkedList, linkedListTraverse);

    }

    private static void reversalOfLinkedList(Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListTraverse linkedListTraverse) {
        ReverseLinkedList reverseLinkedList= new ReverseLinkedList();
        Node<Integer> reversedLinkedList = reverseLinkedList.reverse(updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(reversedLinkedList);
    }

    private static void deleteElementAtTheSpecificPosition(Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListDeletion linkedListDeletion, LinkedListTraverse linkedListTraverse) {
        updatedHeadNodeOfDynamicLinkedList = linkedListDeletion.deleteElementAtPosition(5, updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
    }

    private static Node<Integer> deleteElementFromTheEnd(Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListDeletion linkedListDeletion, LinkedListTraverse linkedListTraverse) {
        updatedHeadNodeOfDynamicLinkedList = linkedListDeletion.deleteElementFromEnd(updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
        return updatedHeadNodeOfDynamicLinkedList;
    }

    private static Node<Integer> deleteElementAtTheBeginning(Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListDeletion linkedListDeletion, LinkedListTraverse linkedListTraverse) {
        updatedHeadNodeOfDynamicLinkedList = linkedListDeletion.deleteElementFromBeginning(updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
        return updatedHeadNodeOfDynamicLinkedList;
    }

    private static void addNewElementAtSpecificPosition(LinkedListInsertion linkedListInsertion, Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListTraverse linkedListTraverse) {
        linkedListInsertion.insertAtPosition(4,70, updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
    }

    private static Node<Integer> addNewElementAtTheEnd(Node<Integer> updatedHeadNodeOfDynamicLinkedList, LinkedListInsertion linkedListInsertion, LinkedListTraverse linkedListTraverse) {
        updatedHeadNodeOfDynamicLinkedList = linkedListInsertion.insertAtEnd(60, updatedHeadNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
        return updatedHeadNodeOfDynamicLinkedList;
    }

    private static Node<Integer> addNewElementInTheBeginning(LinkedListInsertion linkedListInsertion, Node<Integer> headNodeOfDynamicLinkedList, LinkedListTraverse linkedListTraverse) {
        Node<Integer> updatedHeadNodeOfDynamicLinkedList= null;
        updatedHeadNodeOfDynamicLinkedList = linkedListInsertion.insertAtStart(5, headNodeOfDynamicLinkedList);
        linkedListTraverse.traverseInLinkedList(updatedHeadNodeOfDynamicLinkedList);
        return updatedHeadNodeOfDynamicLinkedList;
    }

    private static Node<Integer> createNewLinkedList(LinkedListCreation linkedListCreation, LinkedListTraverse linkedListTraverse) {
        Node<Integer> headNodeOfDynamicLinkedList = linkedListCreation.
                createDynamicLinkedList(10, 20, 30, 40, 50);
        linkedListTraverse.traverseInLinkedList(headNodeOfDynamicLinkedList);
        return headNodeOfDynamicLinkedList;
    }
}
