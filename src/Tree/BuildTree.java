package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    public TreeNode build(String string) {
        if (string.length() == 0 || string.equals("null"))
            return null;
        String[] ip = string.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            TreeNode curr = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if (!currVal.equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(curr.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];

            if (!currVal.equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
