package Tree;

public class SumTree {

    boolean isSumTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return (root.data == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right);
    }

    int sum(TreeNode root) {
        if (root == null)
            return 0;
        return sum(root.left) + root.data + sum(root.right);
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root =  tree.build("3 1 2");
        SumTree sumTree = new SumTree();
        System.out.println(sumTree.isSumTree(root));
    }
}
