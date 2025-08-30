# Meeting Rooms II

- Time Complexity: O(TlogT)
- Space Complexity: O(T)
  - T as length of intervals

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int[] interval: intervals){
            map.merge(interval[0], 1, Integer::sum);
            map.merge(interval[1], -1, Integer::sum);
        }
        int cur = 0,    
            res = 0;
        for(int v: map.values()){
            cur += v;
            res = Math.max(res, cur);
        }
        return res;
    }
}
```

- Time Complexity: O(TlogT)
- Space Complexity: O(T)
  - T as length of intervals

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> rooms = new ArrayList();
        for(int[] interval: intervals){
            rooms.add(new int[]{interval[0], 1});
            rooms.add(new int[]{interval[1], -1});
        }
        Collections.sort(rooms, (a,b) -> a[0] == b[0]? a[1] - b[1]: a[0] - b[0]);
        int count = 0,
            res = 0;
        for(int[] room: rooms){
            count += room[1];
            res = Math.max(res, count);
        }
        return res;
    }
}
```
