import java.io.*;
import java.util.*;

public class Solution {
    static int N, E, ST, DS;
    static int[] myPahts;
    static String path;
    static int cost = 0;
    static int[][] mat;
    static boolean[] bol;
    static ArrayList<String> myPaths = new ArrayList<>();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        E = Integer.parseInt(sc.nextLine());
        
        mat = new int[N+1][N+1];
        bol = new boolean[N+1];
        
        for(int i = 0; i< E; i++) {
            String ps[] = sc.nextLine().split("\\s+");
            int x = Integer.parseInt(ps[0]);
            int y = Integer.parseInt(ps[1]);
            int z = Integer.parseInt(ps[2]);
            
            mat[x][y] = z;
        }
        
        ST = Integer.parseInt(sc.nextLine());
        DS = Integer.parseInt(sc.nextLine());
        
        
        path = ST + " ";
        bol[ST] = true;
        
        findPath(ST);
        
        System.out.println(myPaths.size());
        
        for(int q = 0; q < myPaths.size(); q++) {
            System.out.println(myPaths.get(q));
        }
    }
    
    
    public static void findPath(int cl) {
        if(cl == DS) {
            myPaths.add(path + "[" + cost +"]");
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(mat[cl][i] != 0 && bol[i] != true) {
                cost += mat[cl][i];
                path += i + " ";
                bol[i] = true;
                findPath(i);
                
                cost -= mat[cl][i];
                path = path.substring(0, path.length() - 2);
                bol[i] = false;
            }
        }
    }
}
