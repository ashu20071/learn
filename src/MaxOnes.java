public class MaxOnes {
    public static void main (String[] args) {
        int[] nums=new int[]{1, 0, 1, 1, 0, 1};
        int count=0; int max=0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (max < count) max = count;
            } else count = 0;
        }
        System.out.println(max);
    }
}