import java.util.*;

public class adventOfCodeD6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<Character> newList = new ArrayList<>();
        int sum = 0; int total=0;

        for (int i=0; i<10000; i++){
            String str = scanner.nextLine();
            if (str.equals("done")) break;
            strings.add(str);
        }
        System.out.println("Strings="+strings);

        for (String s:strings){
            if (s.length() != 0){
                list.add(s);
            }
            else {
                System.out.println("List="+list);
                for (String value : list) {
                    for (int j = 0; j < value.length(); j++) {
                        newList.add(value.charAt(j));
                    }
                }
                HashSet<Character> set = new HashSet<>(newList);
                System.out.println("Set="+set);
                //Collections.sort(newList);
                System.out.println("NewList"+newList);
                for (char c:set){
                    //System.out.println("i="+i);
                    if (Collections.frequency(newList,c) == list.size()){
                        sum++;
                    }

                }
                set.clear();
                list.clear();
                newList.clear();
            }
        }

        System.out.println("Answer="+sum);
    }
}