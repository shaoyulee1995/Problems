# Comparison
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of colors
```
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        for(int i = 1; i < neededTime.length; i++){
            char c1 = colors.charAt(i),
                 c2 = colors.charAt(i-1);
            if(c1 == c2){
                res = res + Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        return res;
    }
}
```