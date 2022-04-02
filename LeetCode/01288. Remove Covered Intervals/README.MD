# Arrays
* Time Complexity: O(Nlog(N))
* Space Complexity: O(1)
	* N as length of intervals

## Java
### 2 Pointers
```
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> ((a[0] == b[0])? b[1] - a[1]:  a[0] - b[0]));
        int left = intervals[0][0],
            right = intervals[0][1];
        int deletion = 0, n = intervals.length;
        for(int i = 1; i < n; i++){
            int curLeft = intervals[i][0],
                curRight = intervals[i][1];
            if(left <= curLeft && right >= curRight){
                deletion++;
            }else if(right > curLeft && right < curRight){
                right = curRight;
            }else if(right < curRight){
                left = curLeft;
                right = curRight;
            }
        }
        return n - deletion;
    }
}
```
### 1 Pointer
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

## C++
```
class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& u, const vector<int>& v) {
            return u[0] < v[0] || (u[0] == v[0] && u[1] > v[1]);
        });
        int res = intervals.size();
        int curRight = intervals[0][1];
        for(int i = 1; i < intervals.size(); i++){
            if(intervals[i][1] <= curRight){
                res--;
            }else{
                curRight = max(curRight, intervals[i][1]);
            }
        }
        return res;
    }
};
```