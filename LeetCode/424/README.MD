# Longest Repeating Character Replacement
# 2 Pointers
* Time Complexity: O(S)
* Space Complexity: O(26)
	* S as length of s 
```
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0,
            maxFreq = 0,
            n = s.length();
        int[] cnt = new int[26];
        for(int j = 0; j < n; j++){
            maxFreq = Math.max(maxFreq, ++cnt[s.charAt(j) - 'A']);
            if(j-i+1 > maxFreq + k){
                --cnt[s.charAt(i++)-'A'];
            }
        }
        return n - i;
    }
}
```