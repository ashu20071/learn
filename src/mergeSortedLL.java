public class mergeSortedLL {
    static Node sortedMerge(Node headA, Node headB) {
        Node currA = headA;
        Node currB = headB;
        Node head;
        Node temp;
        if (currA.val <= currB.val){
            head = currA;
            currA = currA.next;
        }
        else{
            head = currB;
            currB = currB.next;
        }
        temp = head;

        while (currA != null && currB != null) {
            if (currA.val <= currB.val){
                temp.next = currA;
                temp = temp.next;
                currA = currA.next;
            }
            else {
                temp.next = currB;
                temp = temp.next;
                currB = currB.next;
            }
        }
        while (currA != null) {
            temp.next = currA;
            temp = temp.next;
            currA = currA.next;
        }
        while (currB != null) {
            temp.next = currB;
            temp = temp.next;
            currB = currB.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node headA = new Node(5);
        Node headB = new Node(2);
        Node currA = headA;
        Node currB = headB;
        currA.next = new Node(10);
        currA = currA.next;
        currA.next = new Node(15);
        currA = currA.next;
        currA.next = new Node(40);
        currB.next = new Node(3);
        currB = currB.next;
        currB.next = new Node(20);
        Node head = sortedMerge(headA, headB);
        linkedListFunctions list = new linkedListFunctions();
        list.printList(head);
    }
}
