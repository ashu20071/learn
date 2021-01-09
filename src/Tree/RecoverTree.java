package Tree;

public class RecoverTree {
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode one = null;
    TreeNode two = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = one.data;
        one.data = two.data;
        two.data = temp;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        if (one == null && pre.data > root.data)
            one = pre;
        if (one != null && pre.data > root.data)
            two = root;
        pre = root;

        traverse(root.right);
    }

    /*
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        TreeNode l = checkL(root.left, root.data);
        if (l != null) {
            swap(root, l);
        }

        TreeNode r = checkR(root.right, root.data);
        if (r != null) {
            swap(root, r);
        }

        recoverTree(root.left);
        recoverTree(root.right);

        if (!isValidBST(root))
            recoverTree(root);
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.data <= min) || (max != null && root.data >= max))
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public void swap(TreeNode a, TreeNode b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public TreeNode checkL(TreeNode root, int dataue) {
        if (root == null)
            return null;
        if (root.data > dataue)
            return root;
        return checkL(root.left, dataue) != null ? checkL(root.left, dataue) : checkL(root.right, dataue);
    }

    public TreeNode checkR(TreeNode root, int dataue) {
        if (root == null)
            return null;
        if (root.data < dataue)
            return root;
        return checkR(root.left, dataue) != null ? checkR(root.left, dataue) : checkR(root.right, dataue);
    }*/

    public static void main(String[] args) {
        buildTree tree = new buildTree();
        TreeNode root = tree.build("3 1 4 N N 2");
        RecoverTree t = new RecoverTree();
        t.recoverTree(root);
        MaxWidth a = new MaxWidth();
        a.levelOrder(root);
    }
}
