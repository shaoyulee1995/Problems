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

- Time Complexity: O(MN)
- Space Complexity: O(1)
  - M as length of matrix
  - N as length of matrix[0]

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRow = false,
                isFirstCol = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                isFirstCol = true;
                break;
            }
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                isFirstRow = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstRow){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(isFirstCol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
```
