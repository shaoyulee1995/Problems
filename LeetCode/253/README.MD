# Meeting Rooms II
# TreeMap
* Time Complexity: O(TlogT)
* Space Complexity: O(T)
	* T as length of intervals
```
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int[] t: intervals){
            map.put(t[0], map.getOrDefault(t[0], 0) + 1);
            map.put(t[1], map.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for(int v: map.values()){
            res = Math.max(res, cur += v);
        }
        return res;
    }
}
```
# Sweep Line
* Time Complexity: O(TlogT)
* Space Complexity: O(T)
	* T as length of intervals
```
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