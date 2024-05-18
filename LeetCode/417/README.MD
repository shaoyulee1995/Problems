# Pacific Atlantic Water Flow

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of heights
  - M as length of heights[0]

```java
class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0){
            return new ArrayList();
        }
        boolean[][] pacific = new boolean[heights.length][heights[0].length],
                    atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList();
        for(int i = 0, m = heights[0].length; i < heights.length; i++){
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, m-1);
        }

        for(int j = 0, n = heights.length; j < heights[0].length; j++){
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlantic, Integer.MIN_VALUE, n-1, j);
        }

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] mat, boolean[][] visited, int height, int x, int y){
        if(x < 0 || x == mat.length || y < 0 || y == mat[0].length || mat[x][y] < height || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int[] dir: dirs){
            dfs(mat, visited, mat[x][y], x+dir[0], y + dir[1]);
        }
    }
}
```
