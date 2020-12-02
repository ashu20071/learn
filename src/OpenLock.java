import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {
    public int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<>();
        int steps = 0;
        String curr = "0000";
        queue.add(curr);

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i=0; i<size; i++){
                if (queue.peek().equals(target)){
                    return steps;
                }
                else {
                    
                }

            }

        }


        return -1;
    }

    public static void main(String[] args){

        String target = "0202";
        String[] deadends = new String[]{"0101","0201"};
        OpenLock openLock = new OpenLock();
        int steps = openLock.openLock(deadends,target);
        System.out.println("Steps="+steps);
    }

}
