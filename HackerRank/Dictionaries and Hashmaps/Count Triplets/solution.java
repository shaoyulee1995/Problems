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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> third = new HashMap<>(),
                            second = new HashMap<>();
        long res = 0;
        for(int i = 0; i < arr.size(); i++){
            if(third.containsKey(arr.get(i))){
                res += third.get(arr.get(i));
            }
            if(second.containsKey(arr.get(i))){
                if(!third.containsKey(r* arr.get(i))){
                    third.put(r*arr.get(i), (long)0);
                }
                third.put(arr.get(i) * r, 
                third.get(arr.get(i) * r) + second.get(arr.get(i)));
            }
            if(!second.containsKey(r * arr.get(i))){
                second.put(r* arr.get(i), (long) 0);
            }
            second.put(arr.get(i) * r, 1 + second.get(r* arr.get(i)));
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
