# Meeting Rooms

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of intervals

```java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
```
