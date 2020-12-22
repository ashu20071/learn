import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//todo: Ashu implement custom queue
//todo: Ashu implement custom HashMap
//todo: Ashu implement exception handling for duplicate null empty invalid scenarios
//todo: create junit testcase

public class LRUCache {
    int size;
    Deque<Integer> queue;
    Map<Integer, Integer> map;

    //constructor with initial capacity
    public LRUCache(int cap) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        size = cap;
    }

    //get value for requested key
    public int get(int key) {
        if (map.get(key) != null) {
            assert queue.peekFirst() != null;
            if (!queue.peekFirst().equals(map.get(key))) {
                queue.remove(map.get(key));
                queue.addFirst(map.get(key));
            }
            return map.get(key);
        }
        //key not present in cache
        return -1;
    }

    //set new/existing value as recently used
    public void set(int key, int value) {
        if (map.get(key) != null) {
            queue.remove(map.get(key));
            map.remove(key);
        }
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
        LRUCache lruCache = new LRUCache(Integer.parseInt(size));

        System.out.println("Enter space separated integers to be paged, preceded by key\nEnter 'ok' when done");
        String inp;
        while (!(inp = reader.readLine()).equals("ok")) {
            String[] s = inp.split(" ");
            if (s[0].equals("GET")) {
                //calling LRU get method
                System.out.println(Integer.parseInt(s[1])+" = "+ lruCache.get(Integer.parseInt(s[1])));
                System.out.println("Current cache = " + lruCache.queue);
                System.out.println("Current Map = " + lruCache.map);
            }
            else {
                //calling LRU set method
                String[] s1 = inp.split(" ");
                lruCache.set(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
                System.out.println("Current cache = " + lruCache.queue);
                System.out.println("Current Map = " + lruCache.map);
            }
            System.out.println("Cache= "+ lruCache.queue);
        }
    }

    public static void main(String[] args) throws IOException {
        getInput();
    }
}
