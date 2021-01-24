import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        boolean isPrime;
        
        for(int i = 2; i <= num; i++) {
            isPrime = true;
            for(int j = 2; j < i; j++) {
                double n = (double)i / j;
                
                if(n - (int)n == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println(i);
            }
        }
    }
}
