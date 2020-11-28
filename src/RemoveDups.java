
public class RemoveDups {
    public static void main(String[] args){
        int[] nums=new int[]{-3,-1,-1,0,0,0,0,0,2};
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        for(int k=0; k<i+1; k++) System.out.print(nums[k]+" ");
    }
}
