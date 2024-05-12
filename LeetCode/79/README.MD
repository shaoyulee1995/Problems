# Word Search
# DFS
* Time Complexity: O(N*3<sup>L</sup>)
* Space Complexity: O(L)
	* N as length of cells in the board
	* L as length of word
```
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int idx, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        if(x < 0 || x == board.length || y < 0 || y == board[0].length || word.charAt(idx) != board[x][y] || visited[x][y]){
            return false;
        }
        visited[x][y] = true;
        char restore = board[x][y];
        board[x][y] = '.';
        boolean traverse = dfs(board, x+1, y, word, idx+1, visited) || 
                           dfs(board, x-1, y, word, idx+1, visited) || 
                           dfs(board, x, y+1, word, idx+1, visited) || 
                           dfs(board, x, y-1, word, idx+1, visited);
        if(traverse){
            return true;
        }
        board[x][y] = restore;
        visited[x][y] = false;
        return false;
    }
}
```
# DFS
* Time Complexity: O(N*3<sup>L</sup>)
* Space Complexity: O(L)
	* N as length of cells in the board
	* L as length of word
```
class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int idx){
        if(idx == word.length()){
            return true;
        }
        visited[x][y] = true;
        for(int[] dir: dirs){
            int nextX = dir[0] + x,
                nextY = dir[1] + y;
            if(nextX < 0 || nextX == board.length || nextY < 0 || nextY == board[0].length ||
                visited[nextX][nextY] || board[nextX][nextY] != word.charAt(idx)){
                continue;
            }
            char tmp = board[nextX][nextY];
            board[nextX][nextY] = ' ';
            if(dfs(board, nextX, nextY, word, idx+1)){
                return true;
            }
            board[nextX][nextY] = tmp;
        }
        visited[x][y] = false;
        return false;
    }
}
```