package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<String> levelOrderTraversal(TreeNode root) {
        if (root == null)
            return null;

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null)
                    list.add("null");
                else {
                    list.add(String.valueOf(node.data));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals("null"))
                list.remove(i);
            else
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root = tree.build("6,3,5,null,2,0,null,null,1");
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        System.out.println(traversal.levelOrderTraversal(root));
    }
}
