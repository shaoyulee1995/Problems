# String
* Time Complexity: O(N^2)
* Space Complexity: O(1)
```
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            int oddLength = longestPalindrome(s, i, i),
                evenLength = longestPalindrome(s, i, i+1);
            int length = Math.max(oddLength, evenLength);
            if(length > maxLength){
                maxLength = length;
                start = i - (length - 1)/2;
            }
        }
        return s.substring(start, start+maxLength);
    }
    public int longestPalindrome(String s, int l, int r){
        if(s == null || l > r){
            return 0;
        }
        while(l <= r && l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }
}
```