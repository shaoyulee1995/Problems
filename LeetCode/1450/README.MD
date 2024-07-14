# Number of Students Doing Homework at a Given Time

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of startTime

```java
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for(int i = 0; i < startTime.length; i++){
            if(startTime[i] <= queryTime && endTime[i] >= queryTime){
                cnt++;
            }
        }
        return cnt;
    }
}
```
