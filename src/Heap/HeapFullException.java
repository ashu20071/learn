package Heap;

public class HeapFullException extends Exception {
    public HeapFullException() {
        System.out.println("Heap is full");
    }
}
