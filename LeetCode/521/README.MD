# Longest Uncommon Subsequence I

# Brian

- Time Complexity: O(1)
- Space Complexity: O(1)

```
public class Solution {
    public int findLUSlength(String a, String b) {
        return (a.equals(b))? -1: Math.max(a.length(), b.length());
    }
}
```
