# String
* Time Complexity: O(S)
* Space Complexity: O(1)
	* S as length of s 
```
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        int i = 0,
            j = 0;
        while(i < s.length() && j < t.length()){
            char sChar = s.charAt(i);
            char tChar = t.charAt(j);
            if(sChar == tChar){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
```