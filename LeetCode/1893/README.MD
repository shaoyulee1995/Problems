# Check if All the Integers in a Range Are Covered

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N is the length of ranges

```java
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for(int[] range: ranges){
            if(range[0] > left){
                return false;
            }
            left = Math.max(left, range[1]+1);
        }
        return left > right;
    }
}
```

