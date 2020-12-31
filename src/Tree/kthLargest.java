package Tree;

public class kthLargest {
    int i = 1;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kLargest(TreeNode root, int K)
    {
        if (root == null)
            return 0;

        kLargest(root.right, K);
        if (i == K)
            return root.data;
        i++;
        kLargest(root.left, K);

        return 0;
    }

    public static void main(String[] args) {
        buildTree tree = new buildTree();
        TreeNode root =  tree.build("78 69 80 4 72 79");
        kthLargest k = new kthLargest();
        System.out.println("Answer = "+k.kLargest(root, 5));
    }
}
