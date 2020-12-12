public class sortedSquares {
    public static int[] sortedSquare(int[] A) {
        for(int i=0; i<A.length; i++){
            A[i]=A[i]*A[i];
        }
        A=sortedArr(A);
        return A;
    }
    public static int[] sortedArr(int[] A){
        for(int i=0; i<A.length; i++){
            for(int j=i; j<A.length; j++){
                if(A[j]<A[i]){
                    int temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;
                }
            }
        }
        return A;
    }
    public static void main(String[] args){
        int[] A=new int[]{-4,-5,-3,10,-12};
        A=sortedSquare(A);
        for(int a : A){
            System.out.print(a+" ");
        }
    }
}
