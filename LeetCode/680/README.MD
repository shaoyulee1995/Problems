# Valid Palindrome II
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public boolean validPalindrome(String s) {
        int L = 0, R = s.length() - 1;
        while(L < R){
            if(s.charAt(L) == s.charAt(R)){
                R--;
                L++;
            }else{
                return validPalindrome(s, L+1, R) || validPalindrome(s, L, R-1);
            }
        }
        return true;
    }
    public boolean validPalindrome(String s, int L, int R) {
        while(L < R){
            if(s.charAt(L) != s.charAt(R)){
                return false;
            }
            L++;
            R--;
        }
        return true;
    }
}
```