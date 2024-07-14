# Shuffle String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for(int i = 0; i < indices.length; i++){
            char val = s.charAt(i);
            res[indices[i]] = val;
        }
        return new String(res);
    }
}
```
