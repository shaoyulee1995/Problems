# Search a 2D Matrix II

- Time Complexity: O(N+M)
- Space Complexity: O(1)
  - N as length of matrix
  - M as length of matrix[0]

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,
            m = matrix[0].length;
        int i = 0, j = m-1;
        while(i < n && j >= 0){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }
            if(num < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
```
