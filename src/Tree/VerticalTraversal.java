package Tree;

import java.util.*;

class NodeObj {
    TreeNode root;
    int x;
    int y;
    public NodeObj(TreeNode root, int x, int y) {
        this.root = root;
        this.x = x;
        this.y = y;
    }
}

public class VerticalTraversal {

    //my approach level order traversal, obj type variable with x,y values
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        // TreeMap to hold key: x-axis, value: list containing obj var with root, x, y values
        Map<Integer, List<NodeObj>> map = new TreeMap<>();
        NodeObj node = new NodeObj(root, 0, 0);
        Queue<NodeObj> queue = new LinkedList<>();
        queue.add(node);
        // Level order traversal
        while (!queue.isEmpty()) {
            NodeObj nodeObj = queue.poll();
            // If map doesn't contain x axis key, simply add new entry
            if (!map.containsKey(nodeObj.x)) {
                List<NodeObj> list = new ArrayList<>();
                list.add(nodeObj);
                map.put(nodeObj.x, list);
            } else {        // else retrieve list for this x-axis key and add new element
                List<NodeObj> list = map.get(nodeObj.x);
                boolean flag = false;
                int ind = 0;
                for (NodeObj ob : list) {
                    if (ob.y == nodeObj.y && nodeObj.root.data < ob.root.data) {        // If y axis value is present in another existing element
                        flag = true;
                        ind = list.indexOf(ob);             // retrieve index of lowest value in list (smaller than current root's value)
                        break;
                    }
                }
                if (flag) {
                    NodeObj obj1 = list.get(ind);
                    list.set(ind, nodeObj);             // set current root's value in retrieved index position
                    while (ind < list.size() - 1) {     // move other values in list forward by 1 position
                        NodeObj obj2 = list.get(ind + 1);
                        list.set(ind + 1, obj1);
                        obj1 = obj2;
                        ind++;
                    }
                    list.add(obj1);
                } else
                    list.add(nodeObj);
            }
            // Add child nodes in queue for further traversal
            if (nodeObj.root.left != null)
                queue.add(new NodeObj(nodeObj.root.left, nodeObj.x - 1, nodeObj.y - 1));
            if (nodeObj.root.right != null)
                queue.add(new NodeObj(nodeObj.root.right, nodeObj.x + 1, nodeObj.y - 1));
        }
        // Create entry set to iterate through map and add node values in result list
        for (Map.Entry<Integer, List<NodeObj>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (NodeObj i : entry.getValue())
                list.add(i.root.data);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        TreeNode root = tree.build("0,2,1,3,null,5,22,9,4,12,25,null,null,13,14,8,6,null,null,null,null,null," +
                "27,24,26,null,17,7,null,28,null,null,null,null,null,19,null,11,10,null,null,null,23,16,15,20,18,null,null,null,null,null,21,null,null,29");
        VerticalTraversal traversal = new VerticalTraversal();
        System.out.println(traversal.verticalTraversal(root));
    }

    /*  // Slight optimization using pair in queue and min, max dist
        public List<List<Integer>> verticalOrder_best(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        int minDistance = 0;
        int maxDistance = 0;
        Map<Integer, List<Integer>> mem = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q  = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i < size; i++) {
                Pair<TreeNode, Integer> p = q.remove();
                TreeNode t = p.getKey();
                int distance = p.getValue();
                minDistance = Math.min(minDistance, distance);
                maxDistance = Math.max(maxDistance, distance);
                mem.putIfAbsent(distance, new ArrayList<>());
                mem.get(distance).add(t.val);
                if(t.left != null) {
                    q.offer(new Pair<>(t.left, distance-1));
                }
                if(t.right != null) {
                    q.offer(new Pair<>(t.right, distance+1));
                }
            }
        }
        for(int i=minDistance; i <= maxDistance; i++) {
            if(mem.containsKey(i)) {
                res.add(mem.get(i));
            }
        }
        return res;
    }

     */

    // Another approach with map<int, map<int, prioqueue>> (nlogn)
    /*
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // First sorted by x position, then y position, then value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> verticalNodes: map.values()) {
            List<Integer> currentYs = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : verticalNodes.values()) {
                while (!nodes.isEmpty()) {
                    currentYs.add(nodes.poll());
                }
            }
            result.add(currentYs);
        }
        return result;
    }
    // x is horizontal axis, y is vertical axis
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
    */
}
