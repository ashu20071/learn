public class magicSquare {

    public static void main(String[] args){

        int[][] magicSq=new int[][]{{4,8,2},{4,5,7},{6,1,6}};

        for(int row=0; row<magicSq.length; row++){
            int sum1=0; int diff=15;
            for(int col=0; col<magicSq.length; col++){

                sum1 += magicSq[row][col];
                sum1 += magicSq[row][col];



            }
            if(sum1 != 15){
                //magicSq[row][2]=magicSq[row][2]+(diff-sum);

            }
            System.out.print("sum1="+sum1+" ");
            int i=1;
            System.out.println();
        }
        for(int row=0; row<magicSq.length; row++){
            int i=0;
            while (i<=3){
                int sum2=0;
                for(int col=0; col<i; col++){
                    sum2 += magicSq[row][col];
                }
                i++;
                System.out.print(sum2+" ");
            }
            System.out.println();

        }

        System.out.println("\n");
        for(int row=0; row<magicSq.length; row++){
            for(int col=0; col<magicSq[row].length; col++){
                System.out.print(magicSq[row][col]+" ");

            }


            System.out.println();
        }

    }
}
