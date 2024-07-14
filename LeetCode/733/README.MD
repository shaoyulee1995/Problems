# Flood Fill

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of image
  - M as length of image[0]

```
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        int n = image.length,
            m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr,sc});
        int oldColor = image[sr][sc];
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0],
                y = pos[1];
            if(visited[x][y]){
                continue;
            }
            if(image[x][y] == color){
                continue;
            }
            image[x][y] = color;
            visited[x][y] = true;
            for(int[] dir: dirs){
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if(newX < 0 || newX == n){
                    continue;
                }
                if(newY < 0 || newY == m){
                    continue;
                }
                if(image[newX][newY] != oldColor){
                    continue;
                }
                if(image[newX][newY] != color){
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        return image;
    }
}
```

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of image
  - M as length of image[0]

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int  OldColor, int newColor){
        if(r < 0 || r == image.length || c < 0 || c == image[0].length || image[r][c] != OldColor){
            return;
        }
        image[r][c] = newColor;
        dfs(image, r+1, c, OldColor, newColor);
        dfs(image, r-1, c, OldColor, newColor);
        dfs(image, r, c+1, OldColor, newColor);
        dfs(image, r, c-1, OldColor, newColor);
    }
}
```
