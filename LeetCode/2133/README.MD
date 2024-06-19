# Check if Every Row and Column Contains All Numbers

# HashSet

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of matrix
  - M as length of matrix[0]

```
class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            HashSet<Integer> row = new HashSet(),
                             col = new HashSet();
            for(int j = 0; j < matrix[0].length; j++){
                if(!row.add(matrix[i][j]) || !col.add(matrix[j][i])){
                    return false;
                }
            }
        }
        return true;
    }
}
```
