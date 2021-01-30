package Tree;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.data);
            return root.data;
        }
        int leftMax = root.left != null ? traverse(root.left): 0;
        int rightMax = root.right != null ? traverse(root.right): 0;
        int chainedMax = Math.max(root.data, Math.max(root.data + leftMax, root.data + rightMax));
        max = Math.max(max, Math.max(chainedMax, root.data + leftMax + rightMax));
        return chainedMax;
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root = tree.build("-10,9,20,null,null,15,7");
        //TreeNode root = tree.build("0,1,1");
        MaxPathSum maxPathSum = new MaxPathSum();
        int max = maxPathSum.maxPathSum(root);
        System.out.println(max);
    }
}