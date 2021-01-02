package SortMethods;

public class BubbleSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean swap = false;
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }
}
