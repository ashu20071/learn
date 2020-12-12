import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//todo: Ashu implement custom queue
//todo: Ashu implement custom HashMap
//todo: Ashuimplement excepition handeling for duplicate null empty invalid scenerios
//todo: create junit testcase

public class LRU {
    int size;
    Deque<Integer> queue;
    HashMap<Integer, Integer> map;

    //constructor with initial capacity
    public LRU(int cap) {
        queue = new LinkedList<>();
        map = new HashMap<>();
        size = cap;
    }

    //get value for requested key
    public int get(int key)
    {
        if (map.containsKey(key)) {
            return map.get(key);
        }

        return -1;                          //key not present in cache
    }

    //set new/existing value as recently used
    public void set(int key, int value)
    {

        if (map.containsKey(key)) {
            System.out.println("Error: Key already present");
        }
        else {

            if (queue.contains(value)){
                //test
                Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
                Integer tempVal = null;

                for(Map.Entry<Integer, Integer>entry: entries )
                {
                    if(entry.getValue().equals(value)){
                        tempVal = entry.getKey();
                        System.out.println( entry.getKey());
                    }
                }
                if (null != tempVal){
                    map.remove(tempVal);
                }


                //tesr
                queue.remove(value);
            }
            if (queue.size() >= size) {
                queue.removeLast();
            }
            queue.offerFirst(value);
            map.put(key,value);
        }
    }

    static void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of LRU cache");
        String size = reader.readLine();
        LRU lru = new LRU(Integer.parseInt(size));

        System.out.println("Enter space separated integers to be paged, preceded by key\nEnter ok when done");
        String inp;
        while (!(inp = reader.readLine()).equals("ok")) {
            String[] s = inp.split(" ");
            lru.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            System.out.println("Current cache = "+lru.queue);
            System.out.println("Current Map= "+lru.map);
        }
    }

    public static void main(String[] args) throws IOException {
        getInput();
     Map<String,String> map =  new HashMap<String,String>();
     map.put("a","value A");
     map.put("b","value B");
     map.put("c","value C");
     map.put("d","value D");
    for (Map.Entry<String,String> entry : map.entrySet()){
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }
    }
}
