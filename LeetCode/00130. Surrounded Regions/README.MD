# DFS
* Time Complexity: O(MN)
* Space Complexity: O(MN)
```
class Solution {
    public void solve(char[][] board) {
        int m = board.length,
            n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    solve(board, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void solve(char[][] board, int i, int j){
        if(i < 0 || i >= board.length){
            return;
        }
        if(j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'X' || board[i][j] == '*'){
            return;
        }
        board[i][j] = '*';
        solve(board, i+1, j);
        solve(board, i-1, j);
        solve(board, i, j+1);
        solve(board, i, j-1);
    }
}
```