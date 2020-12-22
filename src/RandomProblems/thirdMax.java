package RandomProblems;

public class thirdMax {

    public static void main(String[] args){
        int[] nums=new int[]{1,1,2};
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){

            if(nums[i]==first || nums[i]==second || nums[i]==third)  continue;
            if(nums[i]>first){
                third=second;
                second=first;
                first=nums[i];
            }
            else if(nums[i]>second){
                third=second;
                second=nums[i];
            }

            else if(nums[i]>third)  third=nums[i];

            System.out.print("i="+i+"fir="+first+"sec="+second+"thir="+third);
            System.out.println();

        }
        System.out.println(first+" "+second+" "+third);
    }

}
