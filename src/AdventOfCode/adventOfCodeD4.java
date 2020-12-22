package AdventOfCode;

import java.util.*;

public class adventOfCodeD4 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        List<String> list = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        String[] str;String[] str1;

        for (int i=0; i<100000; i++){
            String string = scanner.nextLine();
            if (string.equals("done"))  break;
            strings.add(string);
        }

        int counter=0;int count=0;
        for (String string:strings){
            if (string.length() != 0){
                list.add(string);
            }
            else{
                //System.out.println(list);
                for (String s:list){
                    str = s.split(" ");
                    for (String ss:str){
                        str1 = ss.split(":");
                        hashMap.put(str1[0],str1[1]);
                    }
                }
                //System.out.println("HashMap="+hashMap);
                if (hashMap.containsKey("byr") && hashMap.containsKey("iyr") && hashMap.containsKey("eyr") &&
                        hashMap.containsKey("hgt") && hashMap.containsKey("hcl") && hashMap.containsKey("ecl") &&
                        hashMap.containsKey("pid")){

                    for (String s:list){
                        str = s.split(" ");
                        for (String ss:str){
                            str1 = ss.split(":");
                            if (str1[0].equals("byr")){
                                if (Integer.parseInt(str1[1]) >= 1920 && Integer.parseInt(str1[1]) <= 2002) {
                                    count++;
                                }
                            }
                            if (str1[0].equals("iyr")){
                                if (Integer.parseInt(str1[1]) >= 2010 && Integer.parseInt(str1[1]) <= 2020) {
                                    count++;
                                }
                            }
                            if (str1[0].equals("eyr")){
                                if (Integer.parseInt(str1[1]) >= 2020 && Integer.parseInt(str1[1]) <= 2030) {
                                    count++;
                                }
                            }
                            if (str1[0].equals("hgt")){
                                if (str1[1].contains("cm")){
                                    String[] strings1 = str1[1].split("c");
                                    if (Integer.parseInt(strings1[0]) >= 150 &&
                                            Integer.parseInt(strings1[0]) <= 193){
                                        count++;
                                    }
                                }
                                else if (str1[1].contains("in")){
                                    String[] strings1 = str1[1].split("i");
                                    if (Integer.parseInt(strings1[0]) >= 59 &&
                                            Integer.parseInt(strings1[0]) <= 76){
                                        count++;
                                    }
                                }
                            }
                            if (str1[0].equals("hcl")){
                                if (str1[1].charAt(0) == '#' && str1[1].length() == 7){
                                    char[] chars = str1[1].toCharArray();
                                    int flag=0;
                                    for (char ch:chars){
                                        if ((int) ch < 48 && (int) ch > 57 || (int) ch < 97 && (int) ch > 102){
                                            flag=1;
                                        }
                                    }
                                    if (flag == 0) count++;
                                }
                            }

                            if (str1[0].equals("ecl")){
                                if (str1[1].equals("amb") || str1[1].equals("blu") || str1[1].equals("brn") ||
                                        str1[1].equals("gry") || str1[1].equals("grn") ||
                                        str1[1].equals("hzl") || str1[1].equals("oth") ){
                                    count++;
                                }
                            }

                            if (str1[0].equals("pid")){
                                if (str1[1].length() == 9 && Integer.parseInt(str1[1]) <= 999999999){
                                    count++;
                                }
                            }

                        }
                    }

                }
                System.out.println("Count="+count);
                if (count == 7) counter++;
                count=0;
                list.clear();
                hashMap.clear();
            }
        }
        System.out.println("Answer="+counter);

    }
}
