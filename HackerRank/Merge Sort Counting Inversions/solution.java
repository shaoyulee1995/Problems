import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return merge(arr, 0, arr.length - 1);
    }
    
    static long merge(int[] arr, int l, int r){
        long cnt = 0;
        if(l < r){
            int m = (l+r) / 2;
            cnt+= merge(arr, l, m);
            cnt+= merge(arr, m + 1, r);
            cnt+= merge_sort(arr, l, m, r);
        }
        return cnt;
    }
    static long merge_sort(int[] arr, int l, int m, int r){
        int[] left = Arrays.copyOfRange(arr, l, m+1),
              right = Arrays.copyOfRange(arr, m+1, r+1);
        
        int i = 0, j = 0, k = l;
        long swap = 0;
        
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                k++; i++;
            }else{
                arr[k] = right[j];
                k++; j++;
                swap += (m+1) - (l+i);
            }
        }
        
        while(i < left.length){
            arr[k] = left[i];
            k++; i++;
        }
        while(j < right.length){
            arr[k] = right[j];
            k++; j++;
        }
        return swap;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
