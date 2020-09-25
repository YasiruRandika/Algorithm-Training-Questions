import java.io.*;
import java.util.*;

public class Solution {
    static int array[][];

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        array = new int[x+1][y+1];
        
        System.out.println(getNumSquares(x, y));
    }
    
    public static int getNumSquares(int x, int y) {
        if(x == y) {
            return 1;
        }
        
        if(array[x][y] > 0) {
            return array[x][y];
        }
        
        int xS = Integer.MAX_VALUE, yS = Integer.MAX_VALUE;
        
        for(int i = 1; i <= x / 2; i++) {
            xS = Math.min(getNumSquares(i, y) + getNumSquares(x-i, y), xS);
        }
        
        for(int i = 1; i <= y / 2; i++) {
            yS = Math.min(getNumSquares(x, i) + getNumSquares(x, y - i), yS);
        }
        
        array[x][y] = Math.min(xS, yS);
        
        return array[x][y];
    }
    
}
