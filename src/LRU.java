import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//todo: Ashu implement custom queue
//todo: Ashu implement custom HashMap
//todo: Ashu implement excepition handeling for duplicate null empty invalid scenerios
//todo: create junit testcase
//todo: katchara saaf karo

public class LRU {
    int size;
    Deque<Integer> queue;
    Map<Integer, Integer> map;

    //constructor with initial capacity
    public LRU(int cap) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        size = cap;
    }

    //get value for requested key
    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        //key not present in cache
        return -1;
    }

    //set new/existing value as recently used
    public void set(int key, int value) {

        if (map.containsKey(key)) {
            System.out.println("Error: Key already present");
        } else {
            if (queue.contains(value)) {
                mapIterator(value);
                queue.remove(value);
            }
            if (queue.size() >= size) {
                mapIterator(queue.getLast());
                queue.removeLast();
            }
            queue.addFirst(value);
            map.put(key,value);
        }
    }

    //Find key from given value & delete from map
    private void mapIterator(int value) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Integer tempVal = null;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue().equals(value)) {
                tempVal = entry.getKey();
                System.out.println("Key "+entry.getKey()+" is deleted");
            }
        }
        if (null != tempVal) {
            map.remove(tempVal);
        }
    }

    static void getInput() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of LRU cache");
        String size = reader.readLine();
        // initializing LRU capacity
        LRU lru = new LRU(Integer.parseInt(size));

        System.out.println("Enter space separated integers to be paged, preceded by key\nEnter 'ok' when done");
        String inp;
        while (!(inp = reader.readLine()).equals("ok")) {
            String[] s = inp.split(" ");
            //calling LRU set method
            lru.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            System.out.println("Current cache = " + lru.queue);
            System.out.println("Current Map= " + lru.map);
        }
    }

    public static void main(String[] args) throws IOException {
        getInput();
    }
}
