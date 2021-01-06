package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterInput {
    public String treeInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter tree in space separated string format with N indicating null nodes");
        return bufferedReader.readLine();
    }
}
