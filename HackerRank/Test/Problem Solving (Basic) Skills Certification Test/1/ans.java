import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'possibleChanges' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY usernames as parameter.
     */

    public static List<String> possibleChanges(List<String> usernames) {
        List<String> ans = new ArrayList<>();
    
        boolean found = true;
        for(int i = 0; i < usernames.size(); i++){
            String s = usernames.get(i);
            found = false;
            for(int si = 0; si < s.length() - 1; si++){
                for(int j = si + 1; j < s.length(); j++){
                    if(s.charAt(si) > s.charAt(j)){
                        ans.add("YES");
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
            if(!found){
                ans.add("NO");
            }
        }
        
        return ans;
    }

}
public class Solution {