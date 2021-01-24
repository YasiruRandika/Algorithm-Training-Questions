import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        
        int trang[][] = new int[rows][rows];
        
        for(int i = 0; i < rows; i++) {
            String numbers = scanner.nextLine();
            String strNum[] = numbers.split(" ");
            for(int j = 0; j <= i; j++){
                trang[i][j] = Integer.parseInt(strNum[j]);
            } 
        }
        
       System.out.println(getPath(0, 0, rows, trang, 0));
    }
    
    public static int getPath(int i, int j, int rows, int[][] array, int sum) {
        if(i == rows-1) {
            return sum + array[i][j];
        }
        int left = getPath(i+1, j, rows, array, sum + array[i][j]);
        int right = getPath(i+1, j+1, rows, array, sum + array[i][j]);
        
        if(left > right) {
            return left;
        } else {
            return right;
        }
    }
}
