public class sortMethods {
    static void heapSort(int[] arr) {
        heapify(arr, arr.length - 1);
        int endIndex = arr.length - 1;
        while (endIndex > 0) {
            swap(arr, 0, endIndex);
            endIndex--;
            percolateDown(arr, 0, endIndex);
        }
    }

    static void heapify(int[] arr, int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(arr, index, endIndex);
            index--;
        }
    }

    static void percolateDown(int[] arr, int index, int endIndex) {
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

    public static int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex)
            return -1;
        return leftChildIndex;
    }

    public static int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex)
            return -1;
        return rightChildIndex;
    }

    public static int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex)
            return -1;
        return (index - 1) / 2;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
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

    static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;
        int mid = arr.length / 2 + arr.length % 2;
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[arr.length - mid];
        split(arr, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(arr, firstHalf, secondHalf);
    }

    static void split(int[] arr, int[] firstHalf, int[] secondHalf) {
        int index = 0;
        int secondHalfStartIndex = firstHalf.length;
        for (int i : arr) {
            if (index < firstHalf.length)
                firstHalf[index] = arr[index];
            else
                secondHalf[index-secondHalfStartIndex] = arr[index];
            index++;
        }
    }

    static void merge(int[] arr, int[] firstHalf, int[] secondHalf) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
            if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
                arr[mergeIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }
            else {
                arr[mergeIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < firstHalf.length) {
            while (mergeIndex < arr.length)
                arr[mergeIndex++] = firstHalf[firstHalfIndex++];
        }
        if (secondHalfIndex < secondHalf.length) {
            while (mergeIndex < arr.length)
                arr[mergeIndex++] = secondHalf[secondHalfIndex++];

        }
    }

    static void insertion(int[] arr) {
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

    static void modInsertion(int[] arr, int startIndex, int increment) {
        for (int i=startIndex; i<arr.length; i=i+increment) {
            for (int j=Math.min(i+increment, arr.length - 1); j-increment >= 0; j = j-increment) {
                if (arr[j] < arr[j-increment])
                    swap(arr, j, j-increment);
                else
                    break;
            }
        }
    }

    static void shellSort(int[] arr) {
        int increment = arr.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                modInsertion(arr, startIndex, increment);
            }
            increment /= 2;
        }
    }

    static void bubbleSort(int[] arr) {
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

    static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (arr[j] > arr[i])
                    swap(arr, i , j);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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
        heapSort(arr);
        System.out.print("\nSorted List (heap sort) = ");
        printList(arr);
    }
}
