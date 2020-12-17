class MyLinkedList {
    Node head;
    int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(8);
        head = null;
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node temp = head;
        for (int i=0; i<index && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return -1;
        else return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node value = new Node(val);
        value.val = val;
        value.next = head;
        head = value;
        length += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node temp = head;
        if (temp == null) {
            Node value = new Node(val);
            head = value;
            length++;
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            Node value = new Node(val);
            temp.next = value;
            value.next = null;
            length++;
        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {addAtHead(val); return;}
        if (index > length) {
            System.out.println("Not allowed");
            return;
        }
        Node temp = head;
        for (int i=0; i<index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node t = temp.next;
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.next = t;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node temp = head;
        if (index == 0) {
            head = head.next;
            length--;
        }
        else {
            for (int i=0; i<index-1 && temp.next!= null; i++) {
                temp = temp.next;
            }
            if (temp.next != null)
                temp.next = temp.next.next;
            length--;
        }
    }

    public void printList() {
        Node temp = head;
        System.out.print("List= [");
        int i = 0;
        while (temp != null && i<length) {
            System.out.print(temp.val+", ");
            temp = temp.next;
            i++;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.printList();
        obj.addAtHead(7);
        obj.printList();
        obj.addAtHead(2);
        obj.printList();
        obj.addAtHead(1);
        obj.printList();
        obj.addAtIndex(15,0);
        obj.printList();
        obj.deleteAtIndex(2);
        obj.printList();
        obj.addAtHead(6);
        obj.printList();
        obj.addAtTail(4);
        obj.printList();
        System.out.println("Obj="+obj.get(4));
        obj.printList();
        /*System.out.println("Obj="+obj.get(1));
        obj.printList();
        obj.addAtHead(6);
        obj.printList();
        obj.addAtTail(2);
        obj.printList();
        System.out.println("Obj="+obj.get(3));
        obj.printList();*/

    }

}

