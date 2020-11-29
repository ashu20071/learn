import java.util.ArrayList;

public class magicSquare {

    public static void main(String[] args){

        int[][] magicSq=new int[][]{{4,8,2},{4,5,7},{6,1,6}};

        int[][][] possValues=new int[][][]{{{8,3,4},{1,5,9},{6,7,2}},
                                            {{8,1,6},{3,5,7},{4,9,2}},
                                            {{4,3,8},{9,5,1},{2,7,6}},
                                            {{6,1,8},{7,5,3},{2,9,4}},
                                            {{2,9,4},{7,5,3},{6,1,8}},
                                            {{6,7,2},{1,5,9},{8,3,4}},
                                            {{4,9,2},{3,5,7},{8,1,6}},
                                            {{2,7,6},{9,5,1},{4,3,8}}};

        int min=100;
        for (int i=0; i<8; i++){
            int diff=0;
            for(int row=0; row<magicSq.length; row++){
                for(int col=0; col<magicSq.length; col++){
                     diff += Math.abs(magicSq[row][col]-possValues[i][row][col]);
                }
            }
            if(diff < min){
                min=diff;
            }

        }

        for (int[] ints : magicSq) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");

            }
            System.out.println();
        }
        System.out.println("min="+min);

    }
}
