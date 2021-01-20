package Tree;

public class TreeNode {
    public int hd;
    public int data;
    public TreeNode left, right;

    public TreeNode (int item) {
        this.data = item;
        left = right = null;
    }
}
