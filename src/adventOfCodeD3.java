import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adventOfCodeD3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        for (int i=0; i<100000; i++){
            String string = scanner.nextLine();
            if (string.equals("done"))  break;
            strings.add(string);
        }
        int count = 0;int k = 0;int slope = 1;int answer = 1;
        while (slope <= 7){
            for (String string : strings) {

                if (string.charAt(k) == '#') {
                    count++;
                }
                k = (k + slope) % string.length();

            }
            System.out.println("Count="+count);
            k=0;
            answer *= count;
            count = 0;
            slope += 2;
        }
        count = 0; k=0;
        for (int i=0; i<strings.size(); i=i+2){

            if (strings.get(i).charAt(k) == '#'){
                count++;
            }
            k = (k+1)%strings.get(i).length();

        }
        System.out.println("Answer="+(long)answer*count);
    }
}
