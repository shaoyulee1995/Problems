# Longest Uncommon Subsequence I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as Max(a.length(), b.length())

```java
public class Solution {
    public int findLUSlength(String a, String b) {
        return (a.equals(b))? -1: Math.max(a.length(), b.length());
    }
}
```
