package RandomProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pickingNumbers {
    public static int PickingNumbers(List<Integer> arr){
        int max=0;int counter=0;
        int[] a=new int[arr.size()];

        for (int i=0; i<a.length; i++)  a[i]=arr.get(i);
        Arrays.sort(a);

        for (int i=0; i<a.length; i++){
            for (int j=i+1; j<a.length; j++){

                if (a[j] == a[i]+1 || a[j] == a[i]){
                    counter++;
                    if (counter>max)    max=counter;
                }

            }
            counter=0;

        }

        return max+1;
    }

    public static void main(String[] args){
        List<Integer> arr=new ArrayList<>();
        arr.add(4);
        arr.add(6);
        arr.add(5);
        arr.add(3);
        arr.add(3);
        arr.add(1);

        System.out.println(arr);
        int answer=PickingNumbers(arr);
        System.out.println("Answer="+answer);

    }

}
