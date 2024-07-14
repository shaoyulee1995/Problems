# Longest Substring with At Most K Distinct Characters

# Sliding Window

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int i = 0,
            res = 0;
        for(int j = 0; j <  s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(map.size() > k){
                char rmChar = s.charAt(i++);
                map.put(rmChar, map.get(rmChar)-1);
                if(map.get(rmChar) == 0){
                    map.remove(rmChar);
                }
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
```
