package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args){
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int size = q.size();
        for (int i=0; i<=size; i++) {
            System.out.println("i="+i);
            if (i < k){
                stack.push(q.poll());
                System.out.println("stack="+stack);
            }

            else if (i == k) {
                for (int j=0; j<k; j++){
                    queue.add(stack.pop());
                    System.out.println("queue="+queue);
                }
            }
            else {
                queue.add(q.poll());
            }
        }
        System.out.println("Queue"+queue);

    }
}
