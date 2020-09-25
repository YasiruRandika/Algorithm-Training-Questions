import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String in[] = scanner.nextLine().split(" ");
        int L = Integer.parseInt(in[0]);
        int N = Integer.parseInt(in[1]);
        
        if(N > 12 || N < 0 || L < 0 || L > 1000000) {
            return;
        }
        
        Map<String, Integer> myMap = new TreeMap<>();
        int max = 1;
        for(int i = 0; i < L; i++) {
            String arr[] = scanner.nextLine().split("\\s+");
            int j = 0;
            if(N > arr.length) {
                continue;
            }
            while(j + N <= arr.length) {
                String newA = "";
                for(int k = j; k < j + N; k++) {
                    newA = newA + arr[k] + ",";
                }
                newA = newA.substring(0, newA.length()-1);
                
                if(myMap.containsKey(newA)) {
                    myMap.put(newA, myMap.get(newA) + 1);
                    if(myMap.get(newA) > max) {
                        max = myMap.get(newA);
                    }
                } else {
                    myMap.put(newA, 1);
                }
                j++;
            }
        }
        Set<String> keys = myMap.keySet();
        for(int n = max; n > 0; n--) {
            for(String st : keys) {
            if(myMap.get(st) == n)
                System.out.println(st + " " + myMap.get(st));
            }
        }
    }
}
