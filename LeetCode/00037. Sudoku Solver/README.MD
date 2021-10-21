* Time Complexity: O(N*N)
* Space Complexity: O(1)
```
class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0){
            return;
        }
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] =='.'){
                   for(char c = '1'; c <='9'; c++){
                       if(valid(board, i, j, c)){
                           board[i][j] = c;
                           if(solve(board)){
                               return true;
                           }else{
                               board[i][j] = '.';
                           }
                       }
                   }
                   return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[i][col] !='.' && board[i][col] == c){
                return false; //check row
            }
            if(board[row][i] != '.' && board[row][i] == c){
                return false; //check col
            }
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] != '.' &&
               board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c){
                return false; //check box
            }     
        }
        return true;
    }
}
```