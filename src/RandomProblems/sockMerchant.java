package RandomProblems;

public class sockMerchant {

        static int sock(){
        int n=5;
        int p=3;
        if(n==p || p==1){
            return 0;
        }
        if(n%2==0){
            if(p%2==0){
                if((((n-p-1)/2)+1) < (((p-1)/2)+1)) {
                    return (((n-p-1)/2)+1);
                }
                else
                    return (((p-1)/2)+1);

            }
            else{
                if((((n-p-1)/2)+1)<(((p-1)/2)))   return (((n-p-1)/2)+1);
                else return (((p-1)/2));

            }
        }

        else{
            if(p%2==0){
                if((((n-p-1)/2))<(((p-1)/2)+1))   return (((n-p-1)/2));
                else return (((p-1)/2)+1);
            }
            else{
                if((((n-p-1)/2))<(((p-1)/2)))   return (((n-p-1)/2)+1);
                else {
                    System.out.println((p-1)/2);
                    return (((p-1)/2));
                }
            }
        }
    }


    public static void main (String[] args) {
        int n=sock();
        System.out.println(n);
    }

}
