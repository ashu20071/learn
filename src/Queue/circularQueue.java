package Queue;

public class circularQueue {


    int[] myQueue;
    int head;
    int tail;
    int currentSize;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public circularQueue(int k) {
        myQueue=new int[k];
        head=-1;
        tail=-1;
        currentSize=0;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            if(isEmpty())  head++;
            tail=(tail+1)%myQueue.length;
            myQueue[tail]=value;
            currentSize++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            if(currentSize == 1){
                head=-1;
                tail=-1;
                currentSize--;
                return true;
            }
            else{
                head=(head+1)%myQueue.length;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()){
            return myQueue[head];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()){
            return myQueue[tail];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return currentSize == myQueue.length;
    }

    public void display(){
        if(isEmpty()) System.out.println("Queue is empty!");
        else {
            for(int i=0; i<myQueue.length; i++){System.out.print(myQueue[i]);}
            System.out.println();
        }

    }

    public static void main(String[] args){
        circularQueue queue=new circularQueue(3);
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.enQueue(1));
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.enQueue(2));
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.enQueue(3));
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.enQueue(4));
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());
        System.out.println(queue.enQueue(4));
        queue.display();
        System.out.print("Head="+queue.Front());
        System.out.println("Tail="+queue.Rear());

    }


}
