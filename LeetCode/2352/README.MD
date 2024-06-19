# Equal Row and Column Pairs

- Time Complexity: O(Max(N, M))
- Space Complexity: O(N)
  - N as length of grid
  - M as length of grid[0]

```java
class Solution {
    public int equalPairs(int[][] grid) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap();
        for(int[] row: grid){
            String r = Arrays.toString(row);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        for(int j = 0; j < grid[0].length; j++){
            int[] col = new int[grid[0].length];
            for(int i = 0; i < grid.length; i++){
                col[i] = grid[i][j];
            }
            res += map.getOrDefault(Arrays.toString(col), 0);
        }
        return res;
    }
}
```
