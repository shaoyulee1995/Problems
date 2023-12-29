# Bit
* Time Complexity: O(Max(S, G))
* Space Complexity: O(1)
	* S as start
    * G as goal
```
class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        while(start != 0 || goal != 0){
            int x = start&1,
                y = goal&1;
            res += ((x^y) ==1)? 1: 0;
            start >>= 1;
            goal >>= 1;
        }
        return res;
    }
}
```