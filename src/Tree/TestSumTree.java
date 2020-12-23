package Tree;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestSumTree {
    buildTree tree = new buildTree();
    sumTree sumTree = new sumTree();

    @Test
    public void calculateSumTree() {
        TreeNode root = tree.build("10 6 4");
        boolean b = sumTree.isSumTree(root);
        assertTrue(b);
    }
}
