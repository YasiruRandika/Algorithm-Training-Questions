import java.io.*;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        
        if(input.length() != 9) {
            return;
        } else {
            int year = Integer.parseInt(input.substring(0, 2));
            year = 1900+year;
            //int months[] = getDays(year);
            char gender;
            
            int days = Integer.parseInt(input.substring(2, 5));
            
            if(days > 0 && days < 367) {
                gender = 'M';
            } else if (days > 500 && days < 867) {
                gender = 'F';
                days = days - 500;
            } else {
                return;
            }
            
            
            String oldD = year + "-01-01";
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            
            try {
                c.setTime(sf.parse(oldD));
            } catch (Exception e) {
                System.out.println(e);
            }
            
            c.add(Calendar.DAY_OF_MONTH, days - 1);
            String newDate = sf.format(c.getTime());
            
            /*
            
            for(int i = 0; i < 12; i++) {
                if(days > months[i]) {
                    days = days - months[i];
                } else {
                    month = i + 1;
                    date = days;
                    break;
                }
            }*/
            
            System.out.println(newDate);
            System.out.println(gender);
        } 
    }
    
    /*
    public static int[] getDays(int year) {
        int days[] = new int[12];
        
        for(int i = 1; i <= 12; i++) {
            YearMonth ym = YearMonth.of(year, i);
            days[i-1] = (ym.lengthOfMonth());
        }
        
        return days;
    }*/
}
