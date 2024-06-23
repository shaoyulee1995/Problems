# Minimum Number of Pushes to Type Word I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of word

```java
class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap();
        int res = 0;
        for(char c: word.toCharArray()){
            map.put(c, map.size()/8+1);
            res += map.get(c);
        }
        return res;
    }
}
```
