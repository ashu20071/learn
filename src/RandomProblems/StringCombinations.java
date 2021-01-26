package RandomProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCombinations {
    StringBuilder output = new StringBuilder();

    public void getCombinations(int start, String inputString) {
        for (int i = start; i < inputString.length(); ++i) {
            output.append(inputString.charAt(i));
            System.out.println(output);
            getCombinations(i + 1, inputString);
            output.setLength(output.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Please enter the input string");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringCombinations combinations= new StringCombinations();
        combinations.getCombinations(0, input);
    }
}
