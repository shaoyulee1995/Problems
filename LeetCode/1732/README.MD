# Find the Highest Altitude
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of gain
```
class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        for(int i = 0, curMax = 0; i < gain.length; i++){
            curMax += gain[i];
            res = Math.max(res, curMax);
        }
        return res;
    }
}
```