package SortMethods;

public class QuickSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (arr[l] <= pivot && l < h)
                l++;
            while (arr[h] > pivot)
                h--;
            if (l < h)
                swap(arr, l, h);
        }
        swap(arr, low, h);
        return h;
    }
}
