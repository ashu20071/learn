package SortMethods;

public class HeapSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void heapSort(int[] arr) {
        heapify(arr, arr.length - 1);
        int endIndex = arr.length - 1;
        while (endIndex > 0) {
            swap(arr, 0, endIndex);
            endIndex--;
            percolateDown(arr, 0, endIndex);
        }
    }

    public void heapify(int[] arr, int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(arr, index, endIndex);
            index--;
        }
    }

    public void percolateDown(int[] arr, int index, int endIndex) {
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);
        if (leftChildIndex != -1 && arr[leftChildIndex] > arr[index]) {
            swap(arr, leftChildIndex, index);
            percolateDown(arr, leftChildIndex, endIndex);
        }
        if (rightChildIndex != -1 && arr[rightChildIndex] > arr[index]) {
            swap(arr, rightChildIndex, index);
            percolateDown(arr, leftChildIndex, endIndex);
        }
    }

    public int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex)
            return -1;
        return leftChildIndex;
    }

    public int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex)
            return -1;
        return rightChildIndex;
    }

    public int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex)
            return -1;
        return (index - 1) / 2;
    }
}
