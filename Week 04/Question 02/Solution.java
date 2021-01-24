import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static String[][] maze;
    static int steps[];
    static int myMaze[][];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        
        if(N < 2 || N > 100) {
            return;
        }
        
        maze = new String[N][N];
        myMaze = new int[N][N];
        
        int monty[] = new int[2];
        ArrayList<String> otherM = new ArrayList();
        int cheese[] = new int[2];
        
        for(int i = 0; i< N; i++) {
            String inp = scanner.nextLine();
            String inpt[] = inp.split(" ");
            for(int j = 0; j < N; j++) {
                String s = inpt[j];
                char ch = s.charAt(0);
                
                if(s.equals("M")) {
                    monty[0] = i;
                    monty[1] = j;
                } else if(s.equals("C")) {
                    cheese[0] = i;
                    cheese[1] = j;
                } else if(ch >= 'A' && ch <= 'Z') {
                    otherM.add(String.valueOf(i) + " " + String.valueOf(j));
                }
                
                maze[i][j] = s;
            }
        }
        
        steps = new int[otherM.size() + 1];
        Arrays.fill(steps, 0);
        System.out.println(findCheese(0, 0, 0));
        /*ArrayList<Integer> omSteps = new ArrayList();
        
         for(int i = 1; i <= otherM.size(); i++) {
             String a[] = otherM.get(i-1).split(" ");
             int x = Integer.parseInt(a[0]);
             int y = Integer.parseInt(a[1]);
            if(findCheese(x, y, i)) {
                omSteps.add(steps[i]);
            }
        }
        
        String ans = "No";
        if(findCheese(monty[0], monty[1], 0)) {
            System.out.println("Ok" + steps[0]);
            ans = "Yes";
            for(int i = 0; i < omSteps.size(); i++) {
                if(steps[0] > omSteps.get(i)) {
                    ans = "No";
                    break;
                }
            }
        }
        
        System.out.println(ans);*/
    }
    
    public static int findCheese(int x, int y, int s) {
        if(x >= N || y >= N || x < 0 || y < 0) {
            return -1;
        }
        
        
        if(maze[x][y].equals("1")) {
            return -1;
        }
        
        if(maze[x][y].equals("C")) {
            return s;
        }
        
        if(myMaze[x][y] == 1) {
            return -1;
        }
        
        myMaze[x][y] = 1;
        int ste[] = {s, s, s, s};
        //System.out.println(ste[0]);
        int ok[] = {0, 0, 0, 0};
        int co = 0;
        
        
        //go right
        int v = findCheese(x, y+1, ++ste[1]);
        if(v != -1) {
            ok[1] = 1;
            ste[1] = v;
            co++;
        }
        
        //move down
        v = findCheese(x+1, y, ++ste[0]);
        if(v != -1){
            ok[0] = 1;
            ste[0]= v;
            co++;
        }
        
        //go up
        v = findCheese(x-1, y, ++ste[2]);
        if(v != -1) {
            ok[2] = 1;
            ste[2]= v;
            co++;
        }
        
        //go left
        v = findCheese(x, y-1, ++ste[3]);
        if(v != -1) {
            ok[3] = 1;
            ste[3]= v;
            co++;
        }
        
        myMaze[x][y] = 0;
        if(co > 0) {
            int finalSt[] = new int[co];
            int j = 0;
            
            for(int i = 0; i < 4; i++) {
                if(ok[i] == 1) {
                    finalSt[j++] = ste[i];
                }
            }
            Arrays.sort(finalSt);
            return finalSt[0];
        }
        
        
        return -1;
    }
}
