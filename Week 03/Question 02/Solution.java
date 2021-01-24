import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        int count = scanner.nextInt();
        int intArray[] = new int[count];
        
        for(int i = 0; i < count; i++) {
            intArray[i] = scanner.nextInt();
        }
        
        for(int i = 0; i < count; i++) {
            System.out.println(factorial(intArray[i]));
        }
    }
    
    public static int factorial(int i) {
        if(i == 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
