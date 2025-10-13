# Latest Time You Can Obtain After Replacing Characters

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String findLatestTime(String s) {
        char[] times = s.toCharArray();
        if (times[0] == '?') {
            times[0] = (times[1] == '?' || times[1] < '2') ? '1' : '0';
        }
        if (times[1] == '?') {
            times[1] = (times[0] == '1') ? '1' : '9';
        }
        if (times[3] == '?') {
            times[3] = '5';
        }
        if (times[4] == '?') {
            times[4] = '9';
        }
        return new String(times);
    }
}
```