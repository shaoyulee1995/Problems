# Valid Sudoku

- Time Complexity: O(MN)
- Space Complexity: O(1)
  - M as length of board.length
  - N as length of board[0].length

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i< board.length; i++){
            if(!verifyCol(board, i)){
                return false;
            }
        }
        for(int i = 0; i < board[0].length; i++){
            if(!verifyRow(board, i)){
                return false;
            }
        }
        for(int i = 0; i< board.length; i+=3){
            for(int j = 0; j < board[0].length; j+=3){
                if(!verifyBox(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyBox(char[][] board, int r, int c){
        HashSet<Character> seen = new HashSet();
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(board[i][j] != '.'){
                    if(!seen.add(board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean verifyRow(char[][] board, int col){
        HashSet<Character> seen = new HashSet();
        for(int i = 0; i < board.length; i++){
            if(board[i][col] != '.'){
                if(!seen.add(board[i][col])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyCol(char[][] board, int row){
        HashSet<Character> seen = new HashSet();
        for(int j = 0; j < board[0].length; j++){
            if(board[row][j] != '.'){
                if(!seen.add(board[row][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
```
