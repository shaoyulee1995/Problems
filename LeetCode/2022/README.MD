# Convert 1D Array Into 2D Array

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - M as m
  - N as n

```
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n){
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        int r = 0,
            c = 0;
        for(int o: original){
            res[r][c++] = o;
            if(c == n){
                r++;
                c = 0;
            }
        }
        return res;
    }
}
```
