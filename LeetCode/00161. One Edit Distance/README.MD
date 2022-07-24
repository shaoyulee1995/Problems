# String 
* Time Complexity: O(S<sup>2</sup>)
* Space Complexity: O(1)
	* S as length of s
```
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        int n = s.length(),
            m = t.length();
        if(n > m){
            return isOneEditDistance(t, s);
        }
        if(n == m - 1){
            return deleteOrInsert(s, t);
        }else if(n == m){
            return replace(s, t);
        }
        return false;
    }
    public boolean deleteOrInsert(String s, String t){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(i).equals(t.substring(i+1));
            }
        }
        return true;
    }
    public boolean replace(String s, String t){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(i+1).equals(t.substring(i+1));
            }
        }
        return false;
    }
}
```
# String 
* Time Complexity: O(S<sup>2</sup>)
* Space Complexity: O(1)
	* S as length of s
```
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        int n = s.length(),
            m = t.length();
        if(n > m){
            return isOneEditDistance(t, s);
        }
       
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(n == m){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(n-m) == 1;
    }
}
```
