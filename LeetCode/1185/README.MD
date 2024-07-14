# Day of the Week

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] names = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int givenDay = getDay(day, month, year);
        int currentDay = getDay(18,2,2022);
        int diff = Math.abs(givenDay-currentDay) % 7;
        if(diff == 0){
            return names[0];
        }
        if(givenDay < currentDay){
            return names[names.length - diff];
        }
        return names[diff];
    }
    public boolean isLeap(int year){
        if(year%100 != 0 && year%4 == 0){
            return true;
        }
        if(year%400 == 0){
            return true;
        }
        return false;
    }
    public int getDay(int day, int month, int year){
        HashMap<Integer, Integer> map = new HashMap();
        map.put(1, 31);
        map.put(2, 28);
        if(isLeap(year)){
            map.put(2, 29);
        }
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
        int sum = 0;
        for(int i = 1971; i < year; i++){
            sum+=365;
            if(isLeap(i)){
                sum+=1;
            }
        }
        for(int i = 1; i < month; i++){
            sum += map.get(i);
        }
        sum += day;
        return sum;
    }
}
```
