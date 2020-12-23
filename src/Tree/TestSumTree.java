package Tree;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestSumTree {

    @Test
    public void validSumTree() {
        buildTree tree = new buildTree();
        TreeNode root =  tree.build("3 1 2");
        sumTree sumTree = new sumTree();
        assertTrue(sumTree.isSumTree(root));
    }

    @Test
    public void invalidSumTree() {
        try {
            buildTree tree = new buildTree();
            TreeNode root =  tree.build("nn");
            sumTree sumTree = new sumTree();
            assertTrue(sumTree.isSumTree(root));
        }
        catch (Exception e) {
            System.out.println("Invalid Tree");
        }
    }

    @Test
    public void nullSumTree() {
        try {
            buildTree tree = new buildTree();
            TreeNode root =  tree.build(null);
            sumTree sumTree = new sumTree();
            assertTrue(sumTree.isSumTree(root));
        }
        catch (Exception e) {
            System.out.println("Tree can't be null");
        }
    }
}
