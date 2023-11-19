# String
* Time Complexity: O(N^2)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty() || s == null){
            return "";
        }
        int indexStart = 0,
            maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            int oddLength = isPalindrome(i, i, s),
                evenLength = isPalindrome(i, i+1, s),
                curLength = Math.max(oddLength, evenLength);
            if(maxLength < curLength){
                maxLength = curLength;
                indexStart = i - (curLength-1)/2;
            }
        }       
        return s.substring(indexStart, indexStart + maxLength);
    }
    public int isPalindrome(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
```