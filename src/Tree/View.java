package Tree;

import java.util.ArrayList;
import java.util.List;

public class View {

    // function should print the topView of the binary tree
    int maxLeft = 0;
    int maxRight = 0;

    void topView(TreeNode root) {
        // add your code
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return;

        getMaxLeft(root, 0, list);
        for (int i = list.size() - 1; i >= 0; i--)
            System.out.print(list.get(i) + " ");

        System.out.print(root.data + " ");
        list.clear();

        getMaxRight(root, 0, list);
        for (Integer integer : list)
            System.out.print(integer + " ");

        maxLeft = 0;
        maxRight = 0;

    }

    void getMaxLeft(TreeNode root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (maxLeft < level) {
            list.add(root.data);
            maxLeft = level;
        }
        getMaxLeft(root.left, level + 1, list);
        getMaxLeft(root.right, level - 1, list);

    }

    void getMaxRight(TreeNode root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (maxRight < level) {
            list.add(root.data);
            maxRight = level;
        }
        getMaxRight(root.right, level + 1, list);
        getMaxRight(root.left, level - 1, list);

    }
}
