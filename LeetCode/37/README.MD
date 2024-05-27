# Sudoku Solver

- Time Complexity: O(9<sup>81</sup>)
- Space Complexity: O(1)

```java
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(char k = '1'; k <= '9'; k++){
                    if(isValid(board, i, j, k)){
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

    public boolean isValid(char[][] board, int x, int y, char k){
        for(int i = 0; i < board.length; i++){
            if(board[x][i] == k){
                return false;
            }
            if(board[i][y] == k){
                return false;
            }
        }

        int startRow = (x/3)*3,
            startCol = (y/3)*3;
        for(int i = startRow; i < startRow+3; i++){
            for(int j = startCol; j < startCol+3; j++){
                if(board[i][j] == k){
                    return false;
                }
            }
        }
        return true;
    }
}
```
