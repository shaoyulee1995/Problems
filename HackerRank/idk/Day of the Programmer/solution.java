import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        boolean leap = false;
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year >1918){
            if((year%4 == 0 && year%100 != 0) || year%400 == 0){
                months[1] = 29;
            }
        }else if(year <= 1917){
            if(year % 4 == 0) {
                months[1] = 29;
            }
        }else{
            months[1] = 15;
        }
        
        
        int sum = 0;
        int m = 0;
        for(int i = 0; i < months.length; i++){
            sum += months[i];
            m = i;
            if(sum > 256){
                break;
            }
        }
        int d = sum - months[m];
        
        
        NumberFormat formatter = new DecimalFormat("00");  
        String day = formatter.format(256-d);
        String month = formatter.format(m+1);
        String ans = day+"."+month+"."+year;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
