# Minimum Number of Taps to Open to Water a Garden
# Greedy
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as n
```
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] coverage = new int[n+1];
        for(int i = 0; i < ranges.length; i++){
            int minIdx = Math.max(0, i-ranges[i]);
            coverage[minIdx] = Math.max(coverage[minIdx], i+ranges[i]);
        }
        int curEnd = 0,
            i = 0,
            pointDestination = 0,
            res = 0;
        while(i < coverage.length && curEnd < n){
            res++;
            while(i < coverage.length && i <= curEnd){
                pointDestination = Math.max(coverage[i++], pointDestination);
            }
            if(pointDestination == curEnd){
                return -1;
            }
            curEnd = pointDestination;
        }
        return res;
    }
}
```