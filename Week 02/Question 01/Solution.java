import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        boolean isPrime = true;
        
        if(num <= 1) {
            isPrime = false;
        } else {
            for(int i = 2; i < num; i++) {
                double n = (double)num / i;
                if(n - (int)n == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if(isPrime) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        }
}
