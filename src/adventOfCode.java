import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adventOfCode {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int a=0;
        int b=0;
        int c=0;
        for (int i=0; i<1000; i++){
            int k=sc.nextInt();
            list.add(k);
            if(k == -2222) break;

        }
        System.out.println(list);

        for (int i=0; i<list.size()-1; i++){
            for (int j=0; j<list.size()-1; j++){
                for (int k=0; k<list.size(); k++){
                    if (list.get(k) == 2020-(list.get(i)+list.get(j))){
                        a=list.get(i);
                        b=list.get(j);
                        c=list.get(k);
                    }
                }

            }
        }
        System.out.println("A="+a+"B="+b+"C="+c+" A*B*C="+(a*b*c));

    }


}
