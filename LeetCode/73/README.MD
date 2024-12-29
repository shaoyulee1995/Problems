# Set Matrix Zeroes

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - N as length of matrix
  - M as length of matrix[0]

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            dfs(matrix, p[0], p[1]);
        }
    }

    public void dfs(int[][] matrix, int row, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
}
```

- Time Complexity: O(MN)
- Space Complexity: O(M + N)
  - M as length of matrix
  - N as length of matrix[0]

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length],
                  columns = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```