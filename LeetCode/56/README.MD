# Merge Intervals

# Arrays

- Time Complexity: O(Nlog(N))
- Space Complexity: O(N)
  - N as length of intervals

```
class Solution {
    public int[][] merge(int[][] ways) {
        Arrays.sort(ways, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> path = new LinkedList();
        for(int[] way: ways){
            if(path.isEmpty() || path.getLast()[1] < way[0]){
                path.add(way);
            }else{
                path.getLast()[1] = Math.max(path.getLast()[1], way[1]);
            }
        }
        return path.toArray(new int[0][]);
    }
}
```

# Arrays

- Time Complexity: O(Nlog(N))
- Space Complexity: O(N)
  - N as length of intervals

```
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int[] cur = intervals[0];
        for(int[] interval: intervals){
            if(cur[1] < interval[0]){
                res.add(cur);
                cur = interval;
            }else{
                cur[1] = Math.max(cur[1], interval[1]);
            }
        }
        res.add(cur);
        return res.toArray(int[][]:: new);
    }
}
```
