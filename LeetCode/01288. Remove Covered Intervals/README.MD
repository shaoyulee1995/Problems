# Arrays
* Time Complexity: O(Nlog(N))
* Space Complexity: O(1)
## Solution 1
```
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int left = intervals[0][0],
            right = intervals[0][1];
        
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] curRange = intervals[i];
            if(left <= curRange[0] && right >= curRange[1]){
                res++;
            }else if(right >= curRange[0] && right <= curRange[1]){
                right = curRange[1];
            }else if(right < curRange[0]){
                left = curRange[0];
                right = curRange[1];
            }
        }
        return intervals.length - res;
    }
}
```
## Solution 2
```
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int res = 0, right = 0;
        for(int[] interval: intervals){
            if(right < interval[1]){
                res++;
                right = interval[1];
            }
        }
        return res;
    }
}
```