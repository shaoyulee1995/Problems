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

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(),
            Q = scan.nextInt();
        int lastAns = 0;
        
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < Q; i++){
            int command = scan.nextInt(),
                x = scan.nextInt(),
                y = scan.nextInt();
            ArrayList<Integer> seq = list.get((x^lastAns) % N);
            if(command == 1){
                seq.add(y);
            }else if(command == 2){
                lastAns = seq.get(y%seq.size());
                System.out.println(lastAns);
            }
        }
        scan.close();
    }
}
