# Matrix Diagonal Sum

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n-1-i];
        }
        if(n%2 != 0){
            sum -= mat[(n-1)/2][(n-1)/2];
        }
        return sum;
    }
}
```
