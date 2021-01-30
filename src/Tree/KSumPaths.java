package Tree;

import java.util.ArrayList;
import java.util.List;

public class KSumPaths {
    List<Integer> list = new ArrayList<>();

    public void kSumPaths(TreeNode root, int k) {
        sumPath(root, k);
    }

    public void sumPath(TreeNode root, int k) {
        if (root == null)
            return;
        list.add(root.data);
        sumPath(root.left, k);
        sumPath(root.right, k);

        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == k)
                printList(list, i);
        }
        list.remove(list.size() - 1);
    }

    public void printList(List<Integer> list, int i) {
        for (int j = i; j < list.size(); j++)
            System.out.print(list.get(j)+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.build("1 3 -1 2 1 4 5 N N 1 N 1 2 N 6");
        KSumPaths kSumPaths = new KSumPaths();
        kSumPaths.kSumPaths(root, 5);
    }
}
