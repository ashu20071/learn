package Heap;

import java.util.Scanner;
import java.util.Random;

public class KLargestElements {
    // K largest elements in a stream of random numbers
    public static void printMaxKElements(int[] randomArray, int k) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);
        for (int number : randomArray) {
            if (!minHeap.isFull())
                minHeap.insert(number);
            else if (minHeap.getHighestPriority().compareTo(number) < 0) {
                minHeap.removeHighestPriority();
                minHeap.insert(number);
            }
        }
        minHeap.printHeapArray(minHeap);
    }

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of stream");
        int length = scanner.nextInt();

        Random random = new Random();
        int[] randomArray = new int[length];
        // Generate random numbers
        for (int i = 0; i < randomArray.length; i++)
            randomArray[i] = random.nextInt(100);

        System.out.println("Enter k");
        int k = scanner.nextInt();

        System.out.print("Random Array = ");
        for (int i : randomArray)
            System.out.print(i+" ");

        System.out.print("\n"+k+" largest elements in random array = ");
        printMaxKElements(randomArray, k);
    }
}