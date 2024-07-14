# Non-overlapping Intervals

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of intervals

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0,
            end = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(end <= interval[0]){
                end = interval[1];
            }else{
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of intervals

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0,
            lastEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(lastEnd > intervals[i][0]){
                res++;
                continue;
            }
            lastEnd = intervals[i][1];
        }
        return res;
    }
}
```
