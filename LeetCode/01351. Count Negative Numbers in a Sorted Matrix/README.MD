# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i = grid.length - 1; i >= 0; i--){
            for(int j = grid[0].length - 1; j >= 0; j--){
                if(grid[i][j] >= 0){
                    break;
                }
                res++;
            }
        }
        return res;
    }
}
```
# Matrix
* Time Complexity: O(log(N+M))
* Space Complexity: O(1)
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            int left = 0,
                right = grid[0].length;
            while(left < right){
                int mid = left + (right - left)/2;
                if(grid[i][mid] >= 0){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            res += grid[i].length - left;
        }
        return res;
    }
}
```