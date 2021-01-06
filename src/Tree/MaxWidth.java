package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    int getMaxWidth(TreeNode root)
    {
        int width;
        int maxWidth = 0;

        int h = height(root);

        for (int i = 1; i <= h; i++) {
            width = getWidth(root, i);
            if (width > maxWidth)
                maxWidth = width;
        }

        return maxWidth;
    }

    int width(TreeNode root, int l) {
        int maxWidth = 0; int widthAtLevel = 0;
        Queue<qObj> queue = new LinkedList<>();
        qObj qObj = new qObj(root, 0);
        qObj temp = qObj;
        queue.add(qObj);
        queue.add(null);
        int width = 1;
        int level = 1; int a = 0; int b = 0;
        System.out.print("Level "+level+" = ");
        while(!queue.isEmpty()) {
            qObj curr = queue.poll();

            if (curr == null) {
                b = temp.i;
                width = (b - a) + 1;
                if (maxWidth < width)
                    maxWidth = width;
                if (level == l)
                    widthAtLevel = width;
                System.out.print("\tWidth for this level = "+width);
                level++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                    assert queue.peek() != null;
                    a = queue.peek().i;
                    System.out.print("\nLevel " + level + " = ");
                }
            }
            else {
                System.out.print("("+curr.root.data+","+curr.i+") ");
                if (curr.root.left != null)
                    queue.add(new qObj(curr.root.left, 2 * (curr.i)));
                if (curr.root.right != null)
                    queue.add(new qObj(curr.root.right, 2 * (curr.i) + 1));
            }
            temp = curr;
        }
        System.out.println("\nMaxWidth for tree = "+maxWidth);
        //System.out.println("Width at level "+l+" = "+widthAtLevel);
        return widthAtLevel;
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
        root = tree.build("1 3 2 5 3 N 9");
        MaxWidth m = new MaxWidth();
        System.out.println("Width at level 2 = "+m.width(root, 2));
        //System.out.println("MaxWidth of tree = "+m.getMaxWidth(root));
        //System.out.println("Width at level 3 = "+m.getWidth(root, 3));
    }
}
