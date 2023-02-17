# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of matrix
	* M as length of matrix[0]
```
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length,
            m = matrix[0].length,
            startRow = 0,
            startCol = 0,
            endRow = n-1,
            endCol = m-1,
            total = n*m;
        List<Integer> res = new ArrayList();
        while(total > 0){
            for(int i = startCol; i <= endCol && total > 0; total--, i++){
                res.add(matrix[startRow][i]);
            }
            startRow++;
            for(int i = startRow; i <= endRow && total > 0; total--, i++){
                res.add(matrix[i][endCol]);
            }
            endCol--;
            for(int i = endCol; i >= startCol && total > 0; total--, i--){
                res.add(matrix[endRow][i]);
            }
            endRow--;
            for(int i = endRow; i >= startRow && total > 0; total--, i--){
                res.add(matrix[i][startCol]);
            }
            startCol++;
        }
        return res;
    }
}
```