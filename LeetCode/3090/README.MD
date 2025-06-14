# Maximum Length Substring With Two Occurrences

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes in tree

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        int res = 0;
        int[] cnt = new int[26];
        for(int i = 0, j = 0; j < s.length(); j++){
            cnt[s.charAt(j)-'a']++;
            while(cnt[s.charAt(j)-'a'] > 2){
                cnt[s.charAt(i++)-'a']--;
            }
            res = Math.max(res, j-i+1);
        }
        return res;   
    }
}
```