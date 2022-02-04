* Time Complexity: O(N*N)
* Space Complexity: O(1)
```
class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board == null){
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board){
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(char k = '1'; k <= '9'; k++){
                    if(valid(board, i, j, k)){
                        board[i][j] = k;
                        if(solve(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }             
                }
                return false;
            }
        }
        return true;
    }
    public boolean valid(char[][] board, int i, int j, char k){
        int n = board.length;
        for(int x = 0; x < n; x++){
            if(board[x][j] == k){
                return false;
            }
            if(board[i][x] == k){
                return false;
            }
        }
        int startRow = (i/3)*3,
            startCol = (j/3)*3;
        for(int x = startRow; x < startRow + 3; x++){
            for(int y = startCol; y < startCol + 3; y++){
                if(board[x][y] == k){
                    return false;
                }
            }
        }
        return true;
    }
}
```