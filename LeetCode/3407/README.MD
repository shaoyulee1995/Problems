# Substring Matching Pattern

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean hasMatch(String s, String p) {
        int asteriskIndex = p.indexOf("*"),
            firstPart = s.indexOf(p.substring(0, asteriskIndex)),
            secondPart = s.indexOf(p.substring(asteriskIndex+1), firstPart+asteriskIndex);
        return firstPart != -1 && secondPart != -1;
    }
}
```