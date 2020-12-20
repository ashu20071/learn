public class insertionSort {
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

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        int j = 10;
        for (int i=0; i<10; i++) {
            arr[i] = j--;
        }
        System.out.print("Given List = ");
        for (int i : arr)
            System.out.print(i+" ");
        insertion(arr);
        System.out.print("\nSorted List (insertion sort) = ");
        for (int i : arr)
            System.out.print(i+" ");
    }
}
