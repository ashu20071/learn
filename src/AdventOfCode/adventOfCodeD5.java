package AdventOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adventOfCodeD5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Integer> seats = new ArrayList<>();

        for (int i=0; i<10000; i++){
            String string = scanner.nextLine();
            if (string.equals("done"))  break;
            list.add(string);
        }

        int max = 0;

        for (String s : list) {
            int seat = returnSeat(s);
            if (seat > max) max = seat;
            seats.add(seat);
            //System.out.println("Seat="+seat);
        }
        for (int i=0; i<max; i++){
            if (!seats.contains(i)){
                System.out.print(i+" ");
            }
        }

        System.out.println("Answer="+max);
        //System.out.println("List="+list);
    }

    private static int returnSeat(String s) {

        double upperBound = 127; double lowerBound = 0;
        double uB = 7; double lB=0;
        double row = 0; double col = 0; double seat;

        for (int i=0; i<s.length(); i++){

            if (s.charAt(i) == 'F'){
                row = lowerBound + (upperBound - lowerBound) / 2;
                upperBound = row;
            }
            if (s.charAt(i) == 'B'){
                row = lowerBound + Math.ceil((upperBound - lowerBound) / 2);
                lowerBound = row;
            }
            if (s.charAt(i) == 'L'){
                col = lB + (uB - lB) / 2;
                uB = col;
            }
            if (s.charAt(i) == 'R'){
                col = lB + Math.ceil((uB - lB) / 2);
                lB = col;
            }


        }
        //System.out.println("Row="+row+" Col="+col);
        seat = (int)row * 8 + (int)col;
        return (int)seat;
    }


}
