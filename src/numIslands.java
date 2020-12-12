import java.util.*;

public class numIslands {
    public int numIsland (char[][] grid){
        Queue<Character> queue=new LinkedList<>();
        int k=1;
        for (int i=0; i<grid.length-1; i++) {
            for (int j=0; j<grid[i].length; j++) {
                queue.add(grid[i][j]);
                if (queue.peek() == '1'){
                    queue.offer(grid[i+1][j]);
                }
            }

            System.out.println(queue);
            queue.clear();

        }
        return k;
    }

    public static void main(String[] args){
        char[][] grid=new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};

        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
        numIslands numIslands=new numIslands();
        int k=numIslands.numIsland(grid);
        System.out.println(k);

    }



}

