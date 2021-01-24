import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fabonacci(num));
    }
    
    public static int fabonacci(int i) {
        if(i == 0) {
            return 0;
        }
        
        if(i == 1 || i == 2) {
            return 1;
        }
        
        return fabonacci(i - 1) + fabonacci(i - 2);
    }
}
