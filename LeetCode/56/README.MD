# Merge Intervals

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of intervals

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval: intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(int[][]:: new);
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of intervals

```java
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
