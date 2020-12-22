package Tree;

public class sumTree {

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
        buildTree tree = new buildTree();
        TreeNode root =  tree.build("3 1 2");
        sumTree sumTree = new sumTree();
        System.out.println(sumTree.isSumTree(root));
    }

}
