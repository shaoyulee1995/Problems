# Permutation Difference between Two Strings

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int findPermutationDifference(String s, String t) {
        if(s.length() != t.length()){
            return -1;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i)-'a'] += i;
            cnt[t.charAt(i)-'a'] -= i;
        }
        int res = 0;
        for(int i = 0; i < cnt.length; i++){
            res += Math.abs(cnt[i]);
        }
        return res;
    }
}
```