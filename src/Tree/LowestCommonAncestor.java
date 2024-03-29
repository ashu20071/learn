package Tree;

public class LowestCommonAncestor {
    public TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }

    /*TreeNode answer;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (exists(p.left, q.data) || exists(p.right, q.data))
            return p;
        if (exists(q.left, p.data) || exists(q.right, p.data))
            return q;
        check(root, p, q);
        return answer;
    }

    public void check(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null)
            return;

        if ((exists(curr.left, p.data) && exists(curr.right, q.data)) ||
                exists(curr.left, q.data) && exists(curr.right, p.data)) {
            answer = curr;
            return;
        }
        check(curr.left, p, q);
        check(curr.right, p, q);
    }

    public boolean exists(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.data == value)
            return true;
        return exists(root.left, value) || exists(root.right, value);
    }*/

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root = tree.build("3,5,1,6,2,0,8,null,null,7,4");
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        TreeNode lowest = lca.commonAncestor(root, p, q);
        System.out.println(lowest.data);
    }
}
