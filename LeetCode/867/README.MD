# Transpose Matrix
# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of matrix
    * M as length of matrix[0]
```
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
```