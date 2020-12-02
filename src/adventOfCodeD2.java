import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adventOfCodeD2 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int answer=0;

        for (int i=0; i<10000; i++){
            String str = sc.nextLine();
            if (str.equals("done"))    break;
            list.add(str);

        }
        System.out.println(list);

        for (String value : list) {

            String[] s = value.split(":");
            String[] chr = s[0].split(" ");
            String[] num = chr[0].split("-");
            int lower = Integer.parseInt(num[0]);
            int higher = Integer.parseInt(num[1]);

            char[] c = s[1].toCharArray();
            int count = 0;

            if (chr[1].charAt(0) == c[lower]) {
                count++;
            }
            if (chr[1].charAt(0) == c[higher]) {
                count++;
            }
            if (count == 1) answer++;


        }

        System.out.println("Answer= "+answer);

    }

}
