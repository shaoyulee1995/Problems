# Matrix Block Sum

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of mat
  - M as length of mat[0]

```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length,
            m = mat[0].length;
        int[][] sum = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum[i+1][j+1] = mat[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int r1 = Math.max(0, i-k), c1 = Math.max(0, j-k);
                int r2 = Math.min(n-1, i+k), c2 = Math.min(m-1, j+k);
                r1++;r2++;c1++;c2++;
                res[i][j] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return res;
    }
}
```
