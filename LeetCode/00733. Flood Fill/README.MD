# BFS
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of image
	* M as length of image[0]
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
# DFS
* Time Complexity: O(NM)
* Space Complexity: O(1)
	* N as length of image
	* M as length of image[0]
```
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        dfs(image, image[sr][sc], sr, sc, color);
        return image;
    }
    public void dfs(int[][] image, int oldColor, int x, int y, int color){
        if(x == image.length || x < 0){
            return;
        }
        if(y == image[0].length || y < 0){
            return;
        }
        if(image[x][y] != oldColor){
            return;
        }
        image[x][y] = color;
        dfs(image, oldColor, x+1, y, color);
        dfs(image, oldColor, x-1, y, color);
        dfs(image, oldColor, x, y+1, color);
        dfs(image, oldColor, x, y-1, color);  
    }
}
```