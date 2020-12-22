package LinkedList;

public class linkedListFunctions {
    Node rotate(Node head, int k) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        Node t = null;
        for (int i = 1; i <= k && head != null; i++) {
            t = head;
            head = head.next;
        }
        assert t != null;
        t.next = null;
        return head;
    }

    Node pairWiseSwap(Node head) {
        Node curr = head;
        Node prevE;
        Node first = null;
        Node nextE;
        while (curr != null && curr.next != null) {
            nextE = curr.next.next;
            prevE = curr.next;
            if (curr == head)
                head = prevE;
            else
                first.next = prevE;
            curr.next = nextE;
            prevE.next = curr;
            first = curr;
            curr = nextE;
        }
        return head;
    }

    Node segregate(Node head)
    {
        Node zeroD = new Node(0); Node oneD = new Node(0); Node twoD = new Node(0);
        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;
        Node curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        if (oneD.next != null)
            zero.next = oneD.next;
        else
            zero.next = twoD.next;
        one.next = twoD.next;
        two.next = null;
        head = zeroD.next;
        return head;
    }

    static Node createList() {
        Node head = new Node(1);
        Node curr = head;
        for (int i = 2; i <= 10; i++) {
        curr.next = new Node(i);
        curr = curr.next;
        }
        return head;
    }

    void printList(Node head) {
        Node curr = head;
        System.out.print("List = [ ");
        while (curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Node head = createList();
        linkedListFunctions list = new linkedListFunctions();
        list.printList(head);
        linkedListFunctions rotateLL = new linkedListFunctions();
        head = rotateLL.segregate(head);
        System.out.print("\nSegregated ");
        list.printList(head);
    }
}
