import java.io.*;
import java.util.*;

public class Solution {

    public static boolean[][] finalArr;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine().trim());
        int y = Integer.parseInt(scanner.nextLine().trim());
        int[][] oArray = new int[x][y];
        
        for(int i = 0; i < x; i++) {
            String newS = scanner.nextLine();
            String[] ar = newS.split(" ");
            for(int j = 0; j < y; j++) {
                oArray[i][j] = Integer.parseInt(ar[j]);
            }
        }
        
        finalArr = new boolean[x][y];
        //Arrays.fill(finalArr, false);
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                finalArr[i][j] = false;
            }
        }
        
        ArrayList<Integer> sizes = new ArrayList();
        int rCount = 0;
         
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(finalArr[i][j] == false) {
                    //System.out.println(i + " " + j);
                    rCount++;
                    sizes.add(findPaths(x, y, oArray, i, j, 0));
                }  
                
            }
        }
        
        int max = sizes.get(0);
        for(Integer in : sizes) {
            if(in > max) {
                max = in;
            }
        }
        
        System.out.println(rCount);
        System.out.println(max);
    }
    
    public static int findPaths(int x, int y, int[][] oArray,int m, int n, int size) {
        int a = oArray[m][n];
        boolean[] walls = wallSides(a);
        //System.out.println(walls[0] + " " + walls[1]+ " " + walls[2]+ " " + walls[3]);
        if(finalArr[m][n] == false) {
            finalArr[m][n] = true;
            size++;
        }
        
        int nextX, nextY;
        
        if(walls[3] == false) {
                  nextX = m+1;
            nextY =  n;
            if(nextX < x && nextX >= 0 && nextY >= 0 && nextY < y) {
            if(finalArr[nextX][nextY] == false) {
            size =  findPaths(x, y, oArray,nextX, nextY, size);}}
        } 
        
        if(walls[2] == false) {
            nextX = m;
            nextY = n+1;
            if(nextX < x && nextX >= 0 && nextY >= 0 && nextY < y){
            if(finalArr[nextX][nextY] == false) {
            size =  findPaths(x, y, oArray,nextX, nextY, size);}}
        }
        
        if(walls[1] == false) {
            nextX = m-1;
            nextY = n;
           if(nextX < x && nextX >= 0 && nextY >= 0 && nextY < y){
            if(finalArr[nextX][nextY] == false) {
            size =  findPaths(x, y, oArray, nextX, nextY, size);}}
        }
        
        if(walls[0] == false) {
            nextX = m;
            nextY = n-1;
            if(nextX < x && nextX >= 0 && nextY >= 0 && nextY < y) {
            if(finalArr[nextX][nextY] == false) {
            size =  findPaths(x, y, oArray,nextX, nextY, size);}}
        }
        
        return size;
    }
    
    public static boolean[] wallSides(int a) {
        boolean walls[] = new boolean[4];
                if(a == 1) {
                    walls = new boolean[]{true , false , false, false};
                } else if(a == 2) {
                    walls = new boolean[]{false, true, false, false};
                }else if(a == 3) {
                    walls = new boolean[]{true, true, false, false};
                } else if(a == 4) {
                    walls = new boolean[]{false, false, true, false};
                } else if(a == 5) {
                    walls = new boolean[]{true, false, true, false};
                } else if(a == 6) {
                    walls = new boolean[]{false, true, true, false};
                }else if(a == 7) {
                    walls = new boolean[]{true, true, true, false};
                }else if(a == 8) {
                    walls = new boolean[]{false, false, false, true};
                } else if(a == 9) {
                    walls = new boolean[]{true, false, false, true};
                } else if(a == 10) {
                    walls = new boolean[]{false, true, false, true};
                } else if(a == 11) {
                    walls = new boolean[]{true, true, false, true};
                } else if(a == 12) {
                    walls = new boolean[]{false, false, true, true};
                } else if(a == 15) {
                    walls = new boolean[]{false, false, true, true};
                } else if(a == 13) {
                    walls = new boolean[]{true, false, true, true};
                } else if(a == 14) {
                    walls = new boolean[]{false, true, true, true};
                }else if(a == 15) {
                    walls = new boolean[]{true, true, true, true};
                }
        return walls;
    }
}
