# Count Negative Numbers in a Sorted Matrix
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
        for(int[] row: grid){
            int n = row.length,
                i = 0,
                j = n;
            while(i < j){
                int mid = i + (j-i)/2;
                if(row[mid] >= 0){
                    i = mid + 1;
                }else{
                    j = mid;
                }
            }
            res += (n-i);
        }
        return res;
    }
}
```