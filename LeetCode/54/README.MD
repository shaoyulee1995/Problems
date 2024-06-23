# Spiral Matrix

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of matrix
  - M as length of matrix[0]

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length,
            startRow = 0,
            startCol = 0,
            endRow = matrix.length-1,
            endCol = matrix[0].length-1;
        List<Integer> res = new ArrayList();
        while(res.size() < total){
            for(int j = startCol; j <= endCol && res.size() < total; j++){
                res.add(matrix[startRow][j]);
            }
            startRow++;
            for(int j = startRow; j <= endRow && res.size() < total; j++){
                res.add(matrix[j][endCol]);
            }
            endCol--;
            for(int j = endCol; j >= startCol && res.size() < total; j--){
                res.add(matrix[endRow][j]);
            }
            endRow--;
            for(int j = endRow; j >= startRow && res.size() < total; j--){
                res.add(matrix[j][startCol]);
            }
            startCol++;
        }
        return res;
    }
}
```
