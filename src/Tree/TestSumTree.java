package Tree;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestSumTree {

    @Test
    public void validSumTree() {
        BuildTree tree = new BuildTree();
        TreeNode root =  tree.build("3 1 2");
        SumTree sumTree = new SumTree();
        assertTrue(sumTree.isSumTree(root));
    }

    @Test
    public void invalidSumTree() {
        try {
            BuildTree tree = new BuildTree();
            TreeNode root =  tree.build("nn");
            SumTree sumTree = new SumTree();
            assertTrue(sumTree.isSumTree(root));
        }
        catch (Exception e) {
            System.out.println("Invalid Tree");
        }
    }

    @Test
    public void nullSumTree() {
        try {
            BuildTree tree = new BuildTree();
            TreeNode root =  tree.build(null);
            SumTree sumTree = new SumTree();
            assertTrue(sumTree.isSumTree(root));
        }
        catch (Exception e) {
            System.out.println("Tree can't be null");
        }
    }
}
