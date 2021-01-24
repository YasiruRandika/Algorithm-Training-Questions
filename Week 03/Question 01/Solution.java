import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        Long num = scanner.nextLong();
        System.out.println(superDigit(num));
    }
    
    public static long superDigit(long i) {
        if(i < 10) {
            return i;
        }
        
        long s = i % 10;
        i = i / 10;
        
        return superDigit(s + superDigit(i));
    } 
}
