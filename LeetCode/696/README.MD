# Count Binary Substrings

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int currentCount = 1,
            previousCount = 0,
            res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currentCount++;
            }else{
                res += Math.min(currentCount, previousCount);
                previousCount = currentCount;
                currentCount = 1;
            }
        }
        return res + Math.min(currentCount, previousCount);
    }
}
```
