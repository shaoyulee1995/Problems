# Longest Increasing Path in a Matrix

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of matrix
  - M as length of matrix[0]

```java
class Solution{
    final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length,
            m = matrix[0].length,
            res = 0;
        cache = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int len = dfs(matrix, i, j);
                res = Math.max(len, res);
            }
        }
        return res;
    }
    public int dfs(int[][] matrix, int i,  int j){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int max = 1;
        for(int[] dir: dirs){
            int x = i + dir[0],
                y = j + dir[1];
            if(x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || matrix[x][y] <= matrix[i][j]){
                continue;
            }
            int len = 1 + dfs(matrix, x, y);
            max = Math.max(len, max);
        }
        cache[i][j] = max;
        return max;
    }

}

```
