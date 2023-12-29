# DFS
* Time Complexity: O(MN)
* Space Complexity: O(1)
    * N as length of board
    * M as length of board[0]

```
class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    dfs(board, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i == board.length){
            return;
        }
        if(j < 0 || j == board[0].length){
            return;
        }
        if(board[i][j] == '.'){
            return;
        }
        board[i][j] = '.';
        dfs(board, i, j+1);
        dfs(board, i+1, j);
    }
}
```