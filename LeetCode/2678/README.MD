# Number of Senior Citizens

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of details

```java
class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for(String detail: details){
            res += (Integer.parseInt(detail.substring(11,13)) > 60)? 1: 0;
        }
        return res;
    }
}
```
