public class sortMethods {
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
        shellSort(arr);
        System.out.print("\nSorted List (shell sort) = ");
        printList(arr);
    }
}
