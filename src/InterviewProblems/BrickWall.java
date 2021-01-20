package InterviewProblems;

import java.util.*;
class obj {
    int key;
    int value;
    public obj(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class BrickWall {
    public int getLeastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> bricks : wall) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i : bricks) {
                list.add(sum + i);
                sum += i;
            }
            //System.out.println(list);
            for (int i : list) {
                if (!map.containsKey(i)) {
                    obj ob = new obj(i, 1);
                    map.put(ob.key, ob.value);
                } else {
                    map.put(i, map.get(i) + 1);
                }
            }
        }
        //System.out.println(map);
        int leastBricks = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((6 - entry.getValue() < leastBricks) && (6 - entry.getValue() > 0))
                leastBricks = 6 - entry.getValue();
        }
        return leastBricks;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));
        //System.out.println(wall);
        BrickWall brickWall = new BrickWall();
        System.out.println("Min number of bricks = "+brickWall.getLeastBricks(wall));
    }
}
