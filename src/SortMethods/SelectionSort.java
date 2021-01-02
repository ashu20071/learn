package SortMethods;

public class SelectionSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (arr[j] > arr[i])
                    swap(arr, i , j);
            }
        }
    }
}
