import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static double medianValue(int[] dp, int d){
        int a = 0, b = 0, cnt = 0;
        
        if(d%2 == 0){
            for(int i = 0; i < dp.length; i++){
                cnt+=dp[i];
                if(d/2 <= cnt){
                    a = i;
                    break;
                }
            }
            for(int i = a; i < dp.length; i++){
                if(d/2 + 1 <= cnt){
                    b = i;
                    break;
                }
                cnt+=dp[i];
            }
            return (a+b)/2.0;
        }else{//odd
            for(int i = 0; i < dp.length; i++){
                cnt += dp[i];
                if(d / 2 < cnt){
                    return i;
                }
            }    
        }
        return 0;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int[] dp = new int[201];
        for(int i = 0; i < d; i++){
            dp[expenditure[i]]++;
        }
        int ans = 0;
        for(int i = d; i < expenditure.length; i++){
            double medium = medianValue(dp, d);
            if(expenditure[i] >= medium*2.0){
                ans++;
            }
            dp[expenditure[i]]++;
            dp[expenditure[i-d]]--;
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
