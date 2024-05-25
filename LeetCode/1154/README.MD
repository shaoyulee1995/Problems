# Day of the Year

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]),
            month = Integer.parseInt(dates[1]),
            res = Integer.parseInt(dates[2]),
            feb = (isLeap(year))? 29: 28;
        int[] days = {0,31,feb,31,30,31,30,31,31,30,31,30,31};
        for(int i = 1; i < month; i++){
            res += days[i];
        }
        return res;
    }

    public boolean isLeap(int year){
        return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
    }
}
```
