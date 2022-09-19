# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as n
	* M as m
```
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int r = Integer.MAX_VALUE,
            c = Integer.MAX_VALUE;
        for(int[] op: ops){
            r = Math.min(r, op[0]);
            c = Math.min(c, op[1]);
        }
        if(r == Integer.MAX_VALUE && c == Integer.MAX_VALUE){
            return m*n;
        }
        return r*c;
    }
}
```