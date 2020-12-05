import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        char[] chars = new char[]{'a','b','c'};
        char[] c=new char[chars.length];
        System.arraycopy(chars, 0, c, 0, chars.length);
        c[1]='d';
        System.out.println("Chars="+ Arrays.toString(chars));
        System.out.println("C="+ Arrays.toString(c));
    }
}
