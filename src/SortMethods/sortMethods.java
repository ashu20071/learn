package SortMethods;

import Heap.MinHeap;

import java.util.ArrayDeque;
import java.util.Deque;

public class sortMethods {
    static void printList(int[] arr) {
        for (int i : arr)
            System.out.print(i+" ");
    }

    static void getList(int[] arr) {
        int j = 10;
        for (int i=0; i<10; i++) {
            arr[i] = j--;
        }
        System.out.print("Given List = ");
        printList(arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        getList(arr);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        System.out.print("\nSorted List (heap sort) = ");
        printList(arr);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.removeLast();
    }
}
