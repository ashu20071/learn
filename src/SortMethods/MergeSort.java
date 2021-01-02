package SortMethods;

public class MergeSort {
    public void mergeSort(int[] arr) {
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

    public void split(int[] arr, int[] firstHalf, int[] secondHalf) {
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

    public void merge(int[] arr, int[] firstHalf, int[] secondHalf) {
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
}
