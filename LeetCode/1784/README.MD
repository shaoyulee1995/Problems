# Check if Binary String Has at Most One Segment of Ones

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == '0' && s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}
```
