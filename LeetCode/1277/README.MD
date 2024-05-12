# Count Square Submatrices with All Ones
# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as matrix.length,
	* M as matrix[0].length
```
class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int n = matrix.length,
            m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] > 0 && i > 0 && j > 0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1],
                                   Math.min(matrix[i][j-1], matrix[i-1][j]))+1;
                }   
                res += matrix[i][j];
            }
        }
        return res;
    }
}
```