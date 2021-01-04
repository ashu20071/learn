package Tree;

public class MaxWidth {
    int getMaxWidth(TreeNode root)
    {
        int width = 0;
        int maxWidth = 0;

        int h = height(root);

        for (int i = 0; i <= h; i++) {
            width = getWidth(root, i);
            if (width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    int height(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    int getWidth(TreeNode root, int level) {

        if (root == null)
            return 0;

        if (level == 1)
            return 1;

        else if (level > 1)
            return getWidth(root.left, level - 1) + getWidth(root.right, level - 1);

        return 0;
    }

    public static void main(String[] args) {
        buildTree tree = new buildTree();
        TreeNode root;
        root = tree.build("1 2 3 ");
        MaxWidth m = new MaxWidth();
        System.out.println("MaxWidth of tree = "+m.getMaxWidth(root));
    }
}
