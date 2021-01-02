package SortMethods;

public class ShellSort {
    public void swap(int[] arr, int index1, int index2) {
        int tempValue = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempValue;
    }

    public void modInsertion(int[] arr, int startIndex, int increment) {
        for (int i=startIndex; i<arr.length; i=i+increment) {
            for (int j=Math.min(i+increment, arr.length - 1); j-increment >= 0; j = j-increment) {
                if (arr[j] < arr[j-increment])
                    swap(arr, j, j-increment);
                else
                    break;
            }
        }
    }

    public void shellSort(int[] arr) {
        int increment = arr.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                modInsertion(arr, startIndex, increment);
            }
            increment /= 2;
        }
    }
}
