# Make Three Strings Equal

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as min of s1, s2, and s3

```java
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0,
            size = Math.min(s1.length(),
                   Math.min(s2.length(),
                            s3.length()));
        while(i < size && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)){
            i++;
        }
        return i == 0? -1: s1.length() + s2.length() + s3.length() - 3*i;
    }
}
```
