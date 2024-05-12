# Insert Interval
# Arrays
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of ways
```
class Solution {
    public int[][] insert(int[][] ways, int[] inserted) {
        LinkedList<int[]> path = new LinkedList();
        int start = inserted[0],
            end = inserted[1],
            idx = 0,
            n = ways.length;
        while(idx < n && ways[idx][1] < start){
            path.add(ways[idx++]);
        }
        while(idx < n && ways[idx][0] <= end){
            start = Math.min(start, ways[idx][0]);
            end = Math.max(end, ways[idx][1]);
            idx++;
        }
        path.add(new int[]{start, end});
        while(idx < n){
            path.add(ways[idx++]);
        }
        return path.toArray(new int[0][]);
    }
}
```
# Arrays
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of ways
```
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList();
        for(int[] interval: intervals){
            if(interval[1] < newInterval[0]){
                res.add(interval);
            }else if(newInterval[1] < interval[0]){
                res.add(newInterval);
                newInterval = interval;
            }else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(int[][]:: new);
    }
}
```