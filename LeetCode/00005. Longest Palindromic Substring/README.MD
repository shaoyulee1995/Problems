# String
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public String longestPalindrome(String s) {
        int idxStart = 0,
            maxSubStrLen = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = getPalindromeLength(s, i, i),
                even = getPalindromeLength(s, i, i+1),
                max = Math.max(odd, even);
            if(max > maxSubStrLen){
                maxSubStrLen = max;
                idxStart = i - (maxSubStrLen-1)/2;
            }
        }
        return s.substring(idxStart, idxStart+maxSubStrLen);
    }

    public int getPalindromeLength(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
```