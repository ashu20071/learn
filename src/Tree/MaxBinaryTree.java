package Tree;

public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        return construct(nums, getMaxIndex(nums, 0, nums.length - 1), 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int maxIndex, int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, getMaxIndex(nums, start, maxIndex - 1), start, maxIndex - 1);
        root.right = construct(nums, getMaxIndex(nums, maxIndex + 1, end), maxIndex + 1, end);
        return root;
    }

    public int getMaxIndex(int[] nums, int start, int end) {
        int max = 0;
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        MaxBinaryTree maxBinaryTree = new MaxBinaryTree();
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        System.out.println(traversal.levelOrderTraversal(maxBinaryTree.constructMaximumBinaryTree(nums)));
    }
}
