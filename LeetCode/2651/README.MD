# Calculate Delayed Arrival Time

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }
}
```
