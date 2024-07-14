# Find the Longest Balanced Substring of a Binary String

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        String temp = "01";
        while(temp.length() <= s.length()){
            if(s.contains(temp)){
                res = temp.length();
            }
            temp = "0" + temp + "1";
        }
        return res;
    }
}
```
