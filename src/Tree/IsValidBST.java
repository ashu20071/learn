package Tree;

public class IsValidBST {
    public boolean validateBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.data <= min) || (max != null && root.data >= max))
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        IsValidBST b = new IsValidBST();
        BuildTree tree = new BuildTree();
        TreeNode root = tree.build("-2147483648 N 2147483647");
        System.out.println(b.validateBST(root));
    }
}
