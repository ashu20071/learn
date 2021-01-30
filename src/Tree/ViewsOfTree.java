package Tree;

import java.io.IOException;
import java.util.*;

public class ViewsOfTree {

    void topView(TreeNode root) {
        if (root == null)
            return;

        Queue<QObj> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();

        queue.add(new QObj(root, 0));

        while (!queue.isEmpty()) {
            QObj curr = queue.poll();

            if (!map.containsKey(curr.i))
                map.put(curr.i, curr.root);

            if (curr.root.left != null)
                queue.add(new QObj(curr.root.left, curr.i - 1));
            if (curr.root.right != null)
                queue.add(new QObj(curr.root.right, curr.i + 1));
        }

        for (Map.Entry<Integer, TreeNode> entry : map.entrySet())
            System.out.print(entry.getValue().data+" ");
    }

    void bottomView(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        root.hd = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            map.put(curr.hd, curr.data);

            if (curr.left != null) {
                curr.left.hd = curr.hd - 1;
                queue.add(curr.left);
            }
            if (curr.right != null) {
                curr.right.hd = curr.hd + 1;
                queue.add(curr.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.print((entry.getValue())+" ");
    }

    int max = 0;
    ArrayList<Integer> list = new ArrayList<>();

    void leftView(TreeNode root) {
        if (root != null)
            list.add(root.data);
        left(root, 1);
        System.out.println(list);
    }

    /* helper method for left view */
    void left(TreeNode root, int level) {
        if (root == null)
            return;

        if (max < level) {
            if (root.left != null) {
                list.add(root.left.data);
                max = level;
            }
            else if (root.right != null) {
                list.add(root.right.data);
                max = level;
            }
        }

        left(root.left, level + 1);
        left(root.right, level + 1);
    }

    void rightView(TreeNode root) {
        if (root != null)
            list.add(root.data);
        rightV(root, 1);
        System.out.println(list);
    }

    /* helper method for right view */
    void rightV(TreeNode root, int level) {
        if (root == null)
            return;

        if (max < level) {
            if (root.right != null) {
                list.add(root.right.data);
                max = level;
            }
            else if (root.left != null) {
                list.add(root.left.data);
                max = level;
            }
        }

        rightV(root.right, level + 1);
        rightV(root.left, level + 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BuildTree tree = new BuildTree();
        EnterInput input = new EnterInput();
        String string = input.treeInput();
        TreeNode root = tree.build(string);
        ViewsOfTree view = new ViewsOfTree();

        System.out.println("Please select view of tree to be displayed from below options:" +
                "\n1. Left View\n2. Right View\n3. Top View\n4. Bottom View");
        int inp = scanner.nextInt();

        switch (inp) {
            case 1 -> {
                System.out.print("Left View = ");
                view.leftView(root);
            }
            case 2 -> {
                System.out.print("Right View = ");
                view.rightView(root);
            }
            case 3 -> {
                System.out.print("Top View = ");
                view.topView(root);
            }
            case 4 -> {
                System.out.print("Bottom View = ");
                view.bottomView(root);
            }
            default -> System.out.println("Please enter integer value (1 to 4)");
        }
    }
}
