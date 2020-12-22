package RandomProblems;

public class MoveZeroes {

    public static void main(String[] args){

        int[] nums=new int[]{0,1,0,3,12};


        int lastNonZeroFoundAt=0;
        for(int i=0; i<nums.length; i++){

            if(nums[i] != 0){

                int temp=nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt]=nums[i];
                nums[i]=temp;

                lastNonZeroFoundAt++;
            }
            System.out.println("i="+i+"lastNonZeroFoundtAt="+lastNonZeroFoundAt+"nums[i]="+nums[i]);

        }

        for(int i:nums)     System.out.print(i+" ");
    }


}
