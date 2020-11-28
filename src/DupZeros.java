public class DupZeros {

    public static void main (String[] args) {
        int arr[]= new int[]{0,0,0,0,0,0,0,0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]);
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
