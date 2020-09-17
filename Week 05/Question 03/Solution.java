import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<ArrayList<String>> array = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean a = true;
        ArrayList<String> newA= new ArrayList(); 
        int r = 0;
        while(r < 75) {
            array.add(new ArrayList<String>());
            r++;
        }
        
        while(a) {
            String input = scanner.nextLine();
            if(input.length() > 75) {return;}
            if(input.equals(".")) {
                a = false;
            } else {
                array.get(input.length() - 1).add(input);
                String s = input.toLowerCase();
                for(int k = 0; k <input.length(); k++) {
                    if(s.charAt(k) < 'a' || s.charAt(k) > 'z') {
                        return;
                    }
                }
            }
        }
        
        ArrayList<String> ar = findChain(0, array, new ArrayList<String>(), 0);
        
        System.out.println(ar.size());
        
        try {
        FileWriter fw = new FileWriter("OUTPUT.TXT");
            PrintWriter printWriter = new PrintWriter(fw);
            for(String s: ar) {
        printWriter.println(s);
            }
        fw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> findChain(int row, ArrayList<ArrayList<String>> array, ArrayList<String> words, int p) {
        if(array.get(row).size() == 0 && row == array.size() - 1) {
            return words;
        }
        if(array.get(row).size() == 0 && words.size() == 0) {
            return findChain(row+1, array, words, 0);
        }
        if(array.get(row).size() == 0) {
            return findChain(row+1, array, words, 1);
        }
        if(row == array.size() - 1) {
            String n = words.get(words.size()-1);
            
            for(int i = 0; i < array.get(row).size(); i++) {
                String sub = array.get(row).get(i).substring(0, words.get(words.size()-1).length());
                if(n.equals(sub)) {
                    words.add(array.get(row).get(i));
                }
            }
            return words;
        }
        
        
        ArrayList<ArrayList<String>> funA = new ArrayList();
        for(int i = 0; i < array.get(row).size(); i++) {
            if(p == 0) {
                words.clear();
            }
            if(words.size() == 0) {
                words.add(array.get(row).get(i));
                funA.add(findChain(row+1, array, words, 1));
            } else {
                String n = words.get(words.size()-1);
                String sub = array.get(row).get(i).substring(0, words.get(words.size()-1).length());
                
                if(n.equals(sub)) {
                    ArrayList<String>  myArray = new ArrayList(words);
                    myArray.add(array.get(row).get(i));
                    funA.add(findChain(row+1, array, myArray, 1));
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < funA.size(); i++) {
            if(funA.get(max).size() < funA.get(i).size()) {
                max = i;
            }
        }
        
        if(funA.size() == 0) {
            return findChain(row+1, array, words, 1);
        }
        return funA.get(max);
    }
}
