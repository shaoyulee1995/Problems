# Longest Substring with At Most Two Distinct Characters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int i = 0,
            res = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > 2){
                char rm = s.charAt(i++);
                map.put(rm, map.get(rm) - 1);
                if(map.get(rm) == 0){
                    map.remove(rm);
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
```
