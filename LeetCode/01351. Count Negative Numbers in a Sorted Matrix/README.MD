# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = grid[0].length -1; j >= 0; j--){
                if(grid[i][j] < 0){
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
```
