import java.io.*;
import java.util.*;

public class Solution {
public static String[] direction;
        public static int[] numSteps;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inArray[] = input.split(",");
        int x = Integer.parseInt(inArray[0]);
        int y = Integer.parseInt(inArray[1]);
        int N = Integer.parseInt(inArray[2]);
        int x1 =x , y1 = y;
        
        if(x <= 0 || x > 100 || y <= 0 || y > 100 || N < 0 || N > 1000) {
            return;
        }
        
        String[] steps = new String[N];
        direction = new String[N];
        numSteps = new int[N];
        
        for(int i = 0; i < N; i++) {
            steps[i] = scanner.nextLine();
            String[] a = steps[i].split(" ");
            direction[i] = a[0];
            if(direction[i].equals("NORTH") || direction[i].equals("EAST") || direction[i].equals("SOUTH") || direction[i].equals("WEST")) {
                
            } else {
                return;
            }
            numSteps[i] = Integer.parseInt(a[1]);
        }
        
        for(int i = 0; i < N; i++) {
            if(numSteps[i] > 100 || numSteps[i] <1) {
                return;
            }
            if(direction[i].equals("NORTH")) {
                y1 = y1 - numSteps[i];
            } else if(direction[i].equals("SOUTH")) {
                y1 = y1 + numSteps[i];
            } else if(direction[i].equals("EAST")) {
                x1 = x1 + numSteps[i];
            } else if(direction[i].equals("WEST")) {
                x1 = x1 - numSteps[i];
            }
            
             
        }
        System.out.println(y1 + "," + x1);
    }
    
    
}
