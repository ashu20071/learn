public class rotateLL {
    public Node rotate(Node head, int k) {
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

    static Node createList() {
        Node head = new Node(1);
        Node curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
        return head;
    }

    static void printList(Node head) {
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
        printList(head);
        rotateLL rotateLL = new rotateLL();
        head = rotateLL.pairWiseSwap(head);
        System.out.print("\nPairWiseSwapped ");
        printList(head);
    }
}
