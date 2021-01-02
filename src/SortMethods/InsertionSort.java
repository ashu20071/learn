package SortMethods;

public class InsertionSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void insertionSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j - 1);
                }
                else
                    break;
            }
        }
    }
}
