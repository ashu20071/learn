package Tree;

import LinkedList.Node;

public class ListToBST {
    public TreeNode sortedListToBST(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        int i;
        for (i = 0; curr != null; i++)
            curr = curr.next;
        curr = head;
        Node temp = curr;
        for (int j = 0; j < i/2; j++) {
            temp = curr;
            curr = curr.next;
        }
        if (curr.next != null)
            temp.next = temp.next.next;
        TreeNode root = new TreeNode(curr.val);
        curr = head;
        while (curr != null) {
            constructBST(root, curr.val);
            curr = curr.next;
        }
        return root;
    }

    public TreeNode constructBST(TreeNode root, int value) {
        if (root == null)
            return new TreeNode(value);
        if (value < root.data)
            root.left = constructBST(root.left, value);
        else if (value > root.data)
            root.right = constructBST(root.right, value);
        return root;
    }

    public static void main(String[] args) {
        Node head = new Node(-10);
        head.next = new Node(-3);
        head.next.next = new Node(0);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        ListToBST listToBST = new ListToBST();
        TreeNode root = listToBST.sortedListToBST(head);
        MaxWidth m = new MaxWidth();
        m.levelOrder(root);
    }
}
