package RandomProblems;

import java.util.ArrayList;

public class numberDissapp {

    public static void main(String[] args){

        int[] nums=new int[]{4, 3, 2, 7, 2, 3, 1};

        ArrayList<Integer> list=new ArrayList<>();
        boolean[] counter=new boolean[nums.length+1];

        for (int num : nums) {
            counter[num] = true;
        }
        //for (boolean i:counter) System.out.print(i+" ");
        //System.out.println();

        for(int i=1; i<counter.length; i++){

            if(!counter[i]){
                list.add(i);
            }
        }

        System.out.println(list);
    }
}
