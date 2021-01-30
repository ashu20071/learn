package Tree;

import LinkedList.Node;

public class ListToBST {
    // covert sorted LinkedList to BST
    public TreeNode sortedListToBST(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        int length;
        for (length = 0; curr != null; length++)
            curr = curr.next;
        int[] arr = new int[length];
        curr = head;
        for (int i = 0; i < length; i++) {
            arr[i] = curr.val;
            curr = curr.next;
        }
        return toBST(arr, 0, length - 1);
    }

    public TreeNode toBST(int[] arr, int start, int end) {
        if (end < start)
            return null;
        int index = (start + end) / 2;
        TreeNode root = new TreeNode(arr[index]);
        root.left = toBST(arr, start, index - 1);
        root.right = toBST(arr, index + 1, end);
        return root;
    }

    /* //Another approach
    ListNode last;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        last = head;
        return sortedListToBST(1, n);
    }

    private TreeNode sortedListToBST(int l,int r) {
        if (r < l) {
            return null;
        }
        int mid = (l+r) / 2;
        TreeNode left = sortedListToBST(l,mid-1);
        TreeNode root = new TreeNode(last.val);
        root.left = left;
        last = last.next;
        root.right = sortedListToBST(mid+1,r);
        return root;
    }
    */

    public static void main(String[] args) {
        Node head = new Node(-10);
        head.next = new Node(-3);
        head.next.next = new Node(0);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);
        ListToBST listToBST = new ListToBST();
        TreeNode root = listToBST.sortedListToBST(head);
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        System.out.println(traversal.levelOrderTraversal(root));
    }
}
