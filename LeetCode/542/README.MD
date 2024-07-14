# 01 Matrix

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of mat
  - M as length of mat[0]

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        for(int level = 1; !queue.isEmpty(); level++){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                for(int[] dir: dirs){
                    int x = dir[0] + node[0],
                        y = dir[1] + node[1];
                    if(x < 0 || x == mat.length || y < 0 || y == mat[0].length){
                        continue;
                    }
                    if(mat[x][y] == -1){
                        mat[x][y] = level;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return mat;
    }
}
```
