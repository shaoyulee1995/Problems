import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'stringAnagram' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY dictionary
     *  2. STRING_ARRAY query
     */

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> ans = new ArrayList<>();
        
        int cnt;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < query.size(); i++){
            char[] qs = query.get(i).toCharArray();
            Arrays.sort(qs);
            if(!map.containsKey(String.valueOf(qs))){
                map.put(String.valueOf(qs), 0);
            }
        }
        
        
            
        for(int j = 0; j < dictionary.size(); j++){
            char[] vocab = dictionary.get(j).toCharArray();
        
            Arrays.sort(vocab);
        
            if(map.containsKey(String.valueOf(vocab))){
                map.put(String.valueOf(vocab), map.get(String.valueOf(vocab)) + 1);
            }
        }
        
        for(int i = 0; i < query.size(); i++){
            char[] qs = query.get(i).toCharArray();
            Arrays.sort(qs);
            ans.add(map.get(String.valueOf(qs)));
        }
        
        return ans;

    }

}
public class Solution {