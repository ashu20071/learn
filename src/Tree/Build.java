package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Build{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        Queue<TreeNode> q = new LinkedList<>();

        String[] input = br.readLine().trim().split(" ");

        TreeNode root = null;
        int j=0;

        while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;

            if(root == null)
            {
                root = new TreeNode(a1);
                q.add(root);
            }

            TreeNode pick = q.peek();
            q.remove();

            if(lr=='L'){
                pick.left = new TreeNode(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;

            if(lr=='R'){
                pick.right = new TreeNode(a2);
                q.add(pick.right);
            }

            n-=2;
        }
        new View().topView(root);
        System.out.println();
    }
}
