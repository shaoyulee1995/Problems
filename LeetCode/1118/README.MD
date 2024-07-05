# Number of Days in a Month

- Time Complexity: O(1)
- Space Complexity: O(1)

```
class Solution {
    private static final int[] months = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int numberOfDays(int year, int month) {
        if(month != 2){
            return months[month];
        }
        return isLeap(year)? 29: 28;
    }
    private boolean isLeap(int year){
        if(year % 100 == 0){
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
}
```
