# Minimum Number of Moves to Seat Everyone

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of seats

```java
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for(int i = 0; i < seats.length; i++){
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
```
