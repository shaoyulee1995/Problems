import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
               
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                char[] str = s.substring(i  ,j + 1).toCharArray();
                Arrays.sort(str);
                if(!map.containsKey(new String(str))){
                    map.put(new String(str), 0);
                }
                map.put(new String(str), map.get(new String(str)) + 1);
            }        
        }
        int cnt = 0;
        for(String k: map.keySet()){
            int v = map.get(k);
            cnt += (v*(v-1))  / 2;
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
