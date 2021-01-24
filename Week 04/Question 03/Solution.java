import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        
        String[] sentences = new String[num];
        
        int i = 0;
        
        while(i < num) {
            sentences[i] = scanner.nextLine();
            i++;
        }
        
        i = 0;
        
        while(i < num) {
            findMostWord(sentences[i]);
            i++;
        }
            
    }
        
    public static void findMostWord(String sen) {
        String[] words = sen.split(" ");
            int array[] = new int[words.length];
            Arrays.fill(array, 0);
            
            for(int j = 0; j < array.length; j++) {
                for(int k = 0; k < array.length; k++) {
                    if(words[j] != null && words[j].equals(words[k])){
                        array[j]++;
                        if(j != k) {
                        words[k] = null;
                        }
                    }
                }
            }
            
            int max = array[0];
            
            for(int i = 1; i < array.length; i++) {
                if(max < array[i]) {
                    max = array[i];
                }
            }
            
            ArrayList<String> mostW = new ArrayList();
            for(int p = 0; p < array.length; p++) {
                if(max == 1) {
                    System.out.println("-1");
                    return;
                }
                if(array[p] == max) {
                    mostW.add(words[p]);
                    System.out.print(words[p] + " ");
                }
            }
        System.out.println();
        }
}
