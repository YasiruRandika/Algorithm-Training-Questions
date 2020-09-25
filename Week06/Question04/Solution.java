import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n > 100 || n < 1) {
            return;
        }
        
        int a  = getNum(n);
        
        if(a % 2 == 0) {
            System.out.println("go");
        } else {
            System.out.println("stay");
        }  
    }
    
    public static int getNum(int n) {
        if(n < 10) {
            return n;
        }
        
        return getNum((n/10) + (n%10));
    }
}
