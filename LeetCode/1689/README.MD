# Partitioning Into Minimum Number Of Deci-Binary Numbers

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for(char c: n.toCharArray()){
            res = Math.max(c-'0', res);
        }
        return res;
    }
}
```
