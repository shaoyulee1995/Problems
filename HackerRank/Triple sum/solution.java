import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        a = removeDuplicate(a);
        b = removeDuplicate(b);
        c = removeDuplicate(c);
            
        long sum = 0;
        for(int q = 0; q < b.length; q++){
            sum += (getIndex(a, b[q])+1) * (getIndex(c, b[q])+1);
        }
        return sum;
    }
    
    static long getIndex(int[] a, int value){
        int low = 0, high = a.length - 1;
        long cnt = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(value >= a[mid]){
                cnt = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return cnt;
    }
    static int[] removeDuplicate(int[] arr){
        Arrays.sort(arr);
        Set<Integer> s = new TreeSet<>();
        for(int item: arr){
            s.add(item);
        }
        
        int[] new_arr = new int[s.size()];
        
        int i = 0;
        for(int item: s){
            new_arr[i++] = item;
        }
        return new_arr;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
