# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of matrix
    * M as length of matrix[0]
```
class Solution {
    public void rotate(int[][] matrix) {
        swapRow(matrix);
        swapDiagonal(matrix);
    }

    public void swapDiagonal(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void swapRow(int[][] matrix){
        for(int i = 0, j = matrix.length-1; i < j; i++, j--){
            int[] tempRow = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tempRow;
        }
    }
}
```