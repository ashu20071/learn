public class Heights {


    //create a sort method

    public static void main(String[] args) {

        int[] heights=new int[]{1,1,4,2,1,3};
        int[] sortedHeights=new int[heights.length];

        for (int i=0; i<heights.length; i++)    sortedHeights[i]=heights[i];

        for(int i=0; i<sortedHeights.length; i++){

            for(int j=i; j<sortedHeights.length; j++){

                if(sortedHeights[j]<sortedHeights[i]){
                    int temp=sortedHeights[i];
                    sortedHeights[i]=sortedHeights[j];
                    sortedHeights[j]=temp;
                }
            }
        }

        int moves=0;
        for(int i=0; i<heights.length; i++){

            if(heights[i] != sortedHeights[i])  moves++;
        }

        System.out.println(moves);
        for (int i:heights) System.out.print(i+" ");
        System.out.println();
        for (int i:sortedHeights) System.out.print(i+" ");

    }


}
