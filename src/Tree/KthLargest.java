package Tree;

import java.util.ArrayList;


public class KthLargest {
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

    //return kth smallest element in a binary search tree
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return arr;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
        return arr;
    }


    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root =  tree.build("78 69 80 4 72 79");
        KthLargest k = new KthLargest();
        System.out.println("Answer = "+k.kthSmallest(root, 5));
    }
}
