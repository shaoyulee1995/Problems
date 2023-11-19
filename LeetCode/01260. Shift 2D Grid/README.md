# HashSet
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of grid
	* M as length of grid[0] 
```
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length,
            m = grid[0].length;
        k = k %(n*m);
        List<List<Integer>> res = new ArrayList();
        int start = n*m - k;
        for(int i = 0; i < m*n;){
            List<Integer> row = new ArrayList();
            for(int j = 0; j < m; j++, i++){
                int pos = (i+start)%(m*n);
                row.add(grid[pos/m][pos%m]);
            }
            res.add(row);
        }
        return res;
    }
}
```